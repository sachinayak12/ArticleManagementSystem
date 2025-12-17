package com.Article.Article.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Data
@Table(name = "article_entity")
@NoArgsConstructor
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long articleId;
    @NonNull
    @Column(name="article_name")
    private String articleName;

    @Lob
    @Column(name = "article_description", columnDefinition = "TEXT")
    private String articleDescription;


    @Column(name="author_id")
    private Long authorId;

}
