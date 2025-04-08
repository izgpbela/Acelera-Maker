package com.blogpessoal.service.maps;

import com.blogpessoal.model.Post;
import com.blogpessoal.model.Tema;
import com.blogpessoal.model.Usuario;
import com.blogpessoal.dto.request.CreatePostRequest;
import com.blogpessoal.dto.response.PostResponse;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {

	public Post toPost(CreatePostRequest request, Usuario usuario, Tema tema) {
        return Post.builder()
                .titulo(request.getTitle())  // Alterado para match com o modelo
                .conteudo(request.getContent())
                .tema(tema)
                .usuario(usuario)
                .dataCriacao(LocalDateTime.now())  // Adicionado campo de data
                .build();
    }

    public PostResponse toPostResponse(Post post) {
        return new PostResponse(
                post.getTitulo(),  // Alterado para match com o modelo
                post.getConteudo(),
                post.getDataCriacao(),
                post.getDataAtualizacao(),
                (post.getTema() != null) ? post.getTema().getDescricao() : null,
                post.getUsuario().getNome(),  // Alterado para match com o modelo
                post.getUsuario().getRole().name()
        );
    }
}