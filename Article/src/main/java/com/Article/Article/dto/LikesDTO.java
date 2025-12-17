package com.Article.Article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikesDTO {

    private Long articleId;  // which article
    private Long likes;      // total likes
}
