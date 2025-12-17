package com.Author.Author.Mapper;

import com.Author.Author.Entity.AuthorEntity;
import com.Author.Author.dto.ArticleDTO;
import com.Author.Author.dto.AuthorCreateDTO;
import com.Author.Author.dto.AuthorDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorDTO toDTO(AuthorEntity author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setAuthorId(author.getAuthorId());
        dto.setAuthorName(author.getAuthorName());

        return dto;
    }
    public static AuthorCreateDTO toCreateDTO(AuthorEntity author) {
        AuthorCreateDTO dto = new AuthorCreateDTO();
        dto.setAuthorName(author.getAuthorName());
        dto.setPassword(author.getPassword());

        return dto;
    }

//    private static List<ArticleDTO> toArticleDTOList(List<ArticleEntity> articles) {
//        return articles.stream().map(article -> {
//            ArticleDTO dto = new ArticleDTO();
//            dto.setArticleId(article.getArticleId());
//            dto.setArticleName(article.getArticleName());
//            dto.setArticleDescription(article.getArticleDescription());
//            return dto;
//        }).collect(Collectors.toList());
//    }

//    public static List<AuthorDTO> allAuthorsDTO(List<AuthorEntity> authors)
//    {
//        AuthorDTO authorDTO = new AuthorDTO();
//        authorDTO.setAuthorId(authors);
//    }
}
