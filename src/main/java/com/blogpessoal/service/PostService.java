package com.blogpessoal.service;

import io.micrometer.common.util.StringUtils;
import com.blogpessoal.exception.PostAlreadyExistException;
import com.blogpessoal.exception.PostNotFoundException;
import com.blogpessoal.exception.ThemeNotFoundException;
import com.blogpessoal.exception.UserNotFoundException;
import com.blogpessoal.model.Post;
import com.blogpessoal.model.Tema;
import com.blogpessoal.dto.request.CreatePostRequest;
import com.blogpessoal.dto.request.UpdatePostRequest;
import com.blogpessoal.dto.response.PostResponse;
import com.blogpessoal.repository.PostRepository;
import com.blogpessoal.repository.TemaRepository;
import com.blogpessoal.repository.UsuarioRepository;
import com.blogpessoal.service.maps.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    
	private final PostRepository postRepository;
    private final UsuarioRepository usuarioRepository;
    private final TemaRepository temaRepository;
    private final PostMapper postMapper;
    private static final String POST_NOT_FOUND = "Post not found with id: ";

    public PostService(PostRepository postRepository, 
                     UsuarioRepository usuarioRepository,
                     TemaRepository temaRepository,
                     PostMapper postMapper) {
        this.postRepository = postRepository;
        this.usuarioRepository = usuarioRepository;
        this.temaRepository = temaRepository;
        this.postMapper = postMapper;
    }

    @Transactional
    public Long createPost(CreatePostRequest request, UUID usuarioId, Long temaId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + usuarioId));

        Tema tema = temaId == null ? null : temaRepository.findById(temaId)
                .orElseThrow(() -> new ThemeNotFoundException("Theme not found with id: " + temaId));

        if (postRepository.existsByTituloAndConteudo(request.title(), request.content())) {
            throw new PostAlreadyExistException("Post already exists with the same title and content");
        }

        Post post = postMapper.toPost(request, usuario, tema);
        post = postRepository.save(post);
        return post.getId();
    }

    @Transactional(readOnly = true)
    public PostResponse getPostById(Long postId) {
        return postRepository.findById(postId)
                .map(postMapper::toPostResponse)
                .orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND + postId));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toPostResponse)
                .toList();
    }

    @Transactional
    public PostResponse updatePost(UpdatePostRequest request, Long postId, Long temaId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND + postId));

        Tema tema = temaId == null ? null : temaRepository.findById(temaId)
                .orElseThrow(() -> new ThemeNotFoundException("Theme not found with id: " + temaId));

        updatePostFields(post, request, tema);
        postRepository.save(post);
        return postMapper.toPostResponse(post);
    }

    private void updatePostFields(Post post, UpdatePostRequest request, Tema tema) {
        if (StringUtils.isNotBlank(request.title())) {
            post.setTitulo(request.title());
        }
        if (StringUtils.isNotBlank(request.content())) {
            post.setConteudo(request.content());
        }
        post.setTema(tema);
    }

    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(POST_NOT_FOUND + postId));
        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> filterPosts(UUID usuarioId, Long temaId) {
        List<Post> posts;

        if (usuarioId != null && temaId != null) {
            posts = postRepository.findByUsuarioIdAndTemaId(usuarioId, temaId);
        } else if (usuarioId != null) {
            posts = postRepository.findByUsuarioId(usuarioId);
        } else if (temaId != null) {
            posts = postRepository.findByTemaId(temaId);
        } else {
            posts = postRepository.findAll();
        }

        return posts.stream()
                .map(postMapper::toPostResponse)
                .toList();
    }
}
