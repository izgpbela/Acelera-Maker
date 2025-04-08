package com.blogpessoal.service.maps;

import com.blogpessoal.model.Role;
import com.blogpessoal.model.Usuario;
import com.blogpessoal.dto.request.CreateUserRequest;
import com.blogpessoal.dto.response.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario toUser(CreateUserRequest request, Role role) {
        return Usuario.builder()
                .id(null)
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(role)
                .build();
    }

    public UserResponse fromUser(Usuario usuario) {
       return new UserResponse(
                usuario.getName(),
                usuario.getEmail(),
                usuario.getRole().name(),
                usuario.getFoto()
       );
    }
}
