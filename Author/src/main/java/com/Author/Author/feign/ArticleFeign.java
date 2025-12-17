package com.Author.Author.feign;

import com.Author.Author.dto.ArticleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "article", url = "http://localhost:8081")
public interface ArticleFeign {
    @GetMapping("/article/get/{authorId}")
    List<ArticleDTO> getArticlesByAuthorId(@PathVariable Long authorId);


//    @GetMapping("/get")
//    ArticleDTO getArticle();

}
