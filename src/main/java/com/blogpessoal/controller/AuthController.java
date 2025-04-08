package com.blogpessoal.controller;

import jakarta.validation.Valid;
import com.blogpessoal.model.Role;
import com.blogpessoal.dto.request.AuthRequest;
import com.blogpessoal.dto.request.CreateUserRequest;
import com.blogpessoal.dto.response.AuthResponse;
import com.blogpessoal.security.JwtUtil;
import com.blogpessoal.security.UserDetailsImpl;
import com.blogpessoal.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@Valid @RequestBody CreateUserRequest request) {
        return register(request, Role.USER);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<AuthResponse> registerAdmin(@Valid @RequestBody CreateUserRequest request) {
        return register(request, Role.ADMIN);
    }

    private ResponseEntity<AuthResponse> register(CreateUserRequest request, Role role) {
        var user = usuarioService.createUser(request, role);
        UserDetailsImpl userDetails = new UserDetailsImpl(usuario);
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}