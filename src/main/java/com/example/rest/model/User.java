package com.example.rest.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "Users")
@FieldNameConstants
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "user", fetch = FetchType.Lazy,  cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<News> newses = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    public void addNews(News news) {
        if (newses == null) newses = new ArrayList<>();
        newses.add(news);
    }

    public void removeNews(long newsId) {
        newses = newses.stream().filter(news -> !news.getId().equals(newsId)).collect(Collectors.toList());
    }

    public void addComment(Comment comment) {
        comment.setUser(this);
        comments.add(comment);
    }
}
