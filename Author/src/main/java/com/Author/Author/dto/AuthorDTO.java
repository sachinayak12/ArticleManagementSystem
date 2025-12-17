package com.Author.Author.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class AuthorDTO {
    private Long authorId;
    private String authorName;

    private  List<ArticleDTO> articles;

}
