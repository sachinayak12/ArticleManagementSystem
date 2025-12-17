package com.Author.Author.Mapper;

import com.Author.Author.Entity.AuthorEntity;
import com.Author.Author.dto.ArticleDTO;
import com.Author.Author.dto.AuthorDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleMapper {
    public static ArticleDTO toDTO(ArticleDTO article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setAuthorId(article.getAuthorId());
        dto.setArticleName(article.getArticleName());
        dto.setArticleDescription(article.getArticleDescription());
        dto.setArticleId(article.getArticleId());

        return dto;
    }
}
