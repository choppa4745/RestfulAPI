package com.example.rest.service.impl_services;

import com.example.rest.model.Comment;
import com.example.rest.model.News;
import com.example.rest.model.User;
import com.example.rest.repository.CommentsRepository;
import com.example.rest.service.CommentService;
import com.example.rest.service.NewsService;
import com.example.rest.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

public class CommentServiceImpl extends AbstractUnitedModelServiceImpl<Comment, UUID, CommentsRepository> implements CommentService {
    private final UserService userService;

    private final NewsService newsService;

    public CommentServiceImpl(CommentsRepository repository, UserService userService, NewsService newsService) {
        super(repository);
        this.userService = userService;
        this.newsService = newsService;
    }

    @Override
    protected Comment updateFields(Comment oldEntity, Comment newEntity) {
        if (!Objects.equals(oldEntity.getComment(), newEntity.getComment())) {
            oldEntity.setComment(newEntity.getComment());
        }

        return oldEntity;
    }

    @Override
    public Page<Comment> findAllByPostId(UUID postId, Pageable pageable) {
        return repository.findAllByPostId(postId, pageable);
    }

    @Override
    public boolean existsByIdAndUserId(UUID id, UUID userId) {
        return repository.existsByIdAndUserId(id, userId);
    }

    @Override
    @Transactional
    public Comment addComment(Comment comment, UUID userId, UUID postId) {
        User user = userService.findById(userId);
        News news = newsService.findById(postId);

        user.addComment(comment);
        news.addComment(comment);

        return save(comment);
    }
}

