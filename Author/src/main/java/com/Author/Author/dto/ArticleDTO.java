package com.Author.Author.dto;

import lombok.Data;
@Data
public  class ArticleDTO {
    private Long articleId;
    private String articleName;
    private String articleDescription;
    private Long authorId;
}
