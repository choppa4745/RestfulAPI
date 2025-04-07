package com.example.rest.service;

import com.example.rest.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CommentService extends UnitedModelService<Comment, UUID> {

    Page<Comment> findAllByPostId(UUID postId, Pageable pageable);

    Comment addComment(Comment comment, UUID userId, UUID postId);

    boolean existsByIdAndUserId(UUID id, UUID userId);
}
