package com.Article.Article.feign;

import com.Article.Article.dto.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@FeignClient(
        name = "author-service",                 // logical name
        url = "http://localhost:8080",
        path="author"// port where author-service runs
)


public interface FeignAuthor {

//    AuthorDTO findByName(String authorName);

    @GetMapping("/{authorId}")
    AuthorDTO findById(@PathVariable  Long authorId);
}
