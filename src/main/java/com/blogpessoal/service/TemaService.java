package com.blogpessoal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogpessoal.dto.request.CreateThemeRequest;
import com.blogpessoal.dto.response.ThemeResponse;
import com.blogpessoal.exception.ThemeAlreadyExistException;
import com.blogpessoal.exception.ThemeNotFoundException;
import com.blogpessoal.model.Tema;
import com.blogpessoal.repository.TemaRepository;
import com.blogpessoal.service.maps.TemaMapper;

@Service
public class TemaService {
    
	private final TemaRepository temaRepository;
    private final TemaMapper mapper;
    private static final String THEME_NOT_FOUND = "Theme not found with id: ";

    public TemaService(TemaRepository temaRepository, TemaMapper mapper) {
        this.temaRepository = temaRepository;
        this.mapper = mapper;
    }

    public Long createTheme(CreateThemeRequest request) {
        String description = request.description().trim();
        if (temaRepository.existsByDescription(description)) {
            throw new ThemeAlreadyExistException("Theme already exists with description: " + description);
        }

        var tema = temaRepository.save(mapper.toTema(request));
        return tema.getId();
    }

    public ThemeResponse getThemeById(Long id) {
        return temaRepository.findById(id)
                .map(mapper::fromTema)
                .orElseThrow(() -> new ThemeNotFoundException(THEME_NOT_FOUND));
    }

    public List<ThemeResponse> getAllThemes() {
        return temaRepository.findAll()
                .stream()
                .map(mapper::fromTema)
                .toList();
    }

    public ThemeResponse updateTheme(Long id, CreateThemeRequest request) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new ThemeNotFoundException(THEME_NOT_FOUND));

        mergeTema(tema, request);
        return mapper.fromTema(tema);
    }

    private void mergeTema(Tema tema, CreateThemeRequest request) {
        String newDescription = request.description().trim();

        if (!tema.getDescription().equals(newDescription) && temaRepository.existsByDescription(newDescription))
            throw new ThemeAlreadyExistException("Theme already exists with description: " + newDescription);

        tema.setDescription(newDescription);
        temaRepository.save(tema);
    }

    public void deleteTema(Long id) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new ThemeNotFoundException(THEME_NOT_FOUND));

        temaRepository.delete(tema);
    }
}
