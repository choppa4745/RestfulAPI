package com.example.rest.service;

import com.example.rest.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NewsService extends UnitedModelService<News, UUID> {

    News addNews(News news, UUID userId, UUID categoryId);

    News updateNews(News news, UUID id, UUID categoryId);

    Page<News> findAllByCategoryId(UUID categoryId, Pageable pageable);

    Page<News> findAllByAuthorId(UUID userId, Pageable pageable);

    Page<News> filterBy(NewsFilterRequest filter);

    boolean existsByIdAndAuthorId(UUID id, UUID authorId);

}
