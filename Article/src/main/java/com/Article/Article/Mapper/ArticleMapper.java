package com.Article.Article.Mapper;

import com.Article.Article.Entity.ArticleEntity;
import com.Article.Article.dto.ArticleDTO;

public class ArticleMapper {
    public static ArticleDTO toDTO(ArticleEntity article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setArticleId(article.getArticleId());
        dto.setArticleName(article.getArticleName());
        dto.setArticleDescription(article.getArticleDescription());
        dto.setAuthorId(article.getAuthorId());
//        dto.setArticles(toArticleDTOList(author.getArticles()));
        dto.setLikes(0L);
        return dto;
    }


    public static ArticleEntity toEntity(ArticleDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("ArticleDTO cannot be null");
        }

        ArticleEntity entity = new ArticleEntity();
        entity.setArticleId(dto.getArticleId());
        entity.setArticleName(dto.getArticleName());
        entity.setArticleDescription(dto.getArticleDescription());
        entity.setAuthorId(dto.getAuthorId());


        return entity;
    }
}
