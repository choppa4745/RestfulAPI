package com.example.rest.repository;

import com.example.rest.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsRepository extends JpaRepository<News, UUID> {

    Page<News> findAllByCategoryId(UUID categoryId, Pageable pageable);

    Page<News> findAllByAuthorId(UUID userId, Pageable pageable);

    boolean existsByIdAndUserId(UUID id, UUID userId);
}
