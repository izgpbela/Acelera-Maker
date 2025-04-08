package com.blogpessoal.service.maps;

import com.blogpessoal.model.Tema;
import com.blogpessoal.dto.request.CreateThemeRequest;
import com.blogpessoal.dto.response.ThemeResponse;
import org.springframework.stereotype.Service;

@Service
public class TemaMapper {

    public Tema toTheme(CreateThemeRequest request) {
        return Tema.builder()
                .id(null)
                .description(request.description())
                .build();
    }

    public ThemeResponse fromTheme(Tema tema) {
        return new ThemeResponse(
                tema.getDescription()
        );
    }
}
