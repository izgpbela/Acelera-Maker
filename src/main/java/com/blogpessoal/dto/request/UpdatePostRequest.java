package com.blogpessoal.dto.request;

import com.blogpessoal.model.Post;

public record UpdatePostRequest(
        String title,
        String content,
        Long temaId
) {
    public UpdatePostRequest(Post post) {
        this(post.getTitle(), post.getContent(), post.getTema() != null ? post.getTema().getId() : null);
    }
}