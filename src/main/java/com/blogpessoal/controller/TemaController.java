package com.blogpessoal.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.dto.request.CreateThemeRequest;
import com.blogpessoal.dto.response.ThemeResponse;
import com.blogpessoal.service.TemaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/themes")
public class TemaController {
    
	private final TemaService temaService;

    public TemaController(TemaService temaService) {
        this.temaService = temaService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createTheme(@Valid @RequestBody CreateThemeRequest request) {
        Long temaId = temaService.createTheme(request);
        return ResponseEntity.created(URI.create("/api/v1/tema/" + temaId)).build();
    }

    @GetMapping("/{temaId}")
    public ResponseEntity<ThemeResponse> getTheme(@PathVariable Long temaId) {
        ThemeResponse tema = temaService.getThemeById(temaId);
        return ResponseEntity.ok(tema);
    }

    @GetMapping
    public ResponseEntity<List<ThemeResponse>> getAllThemes() {
        List<ThemeResponse> tema = temaService.getAllThemes();
        return ResponseEntity.ok(tema);
    }

    @PutMapping("/{temaId}")
    @Transactional
    public ResponseEntity<ThemeResponse> updateTheme(@PathVariable Long temaId,
                                                     @Valid @RequestBody CreateThemeRequest request) {
        ThemeResponse updatedTheme = temaService.updateTheme(temaId, request);
        return ResponseEntity.ok(updatedTheme);
    }

    @DeleteMapping("/{temaId}")
    @Transactional
    public ResponseEntity<Void> deleteTheme(@PathVariable Long temaId) {
        temaService.deleteTema(temaId);
        return ResponseEntity.noContent().build();
    }

}
