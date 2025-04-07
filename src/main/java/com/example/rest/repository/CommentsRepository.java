package com.example.rest.repository;

import com.example.rest.model.Category;
import com.example.rest.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comment, UUID> {

    Page<Comment> findAllByPostId(UUID postId, Pageable pageable);

    boolean existsByIdAndUserId(UUID id, UUID userId);

}
