package com.Article.Article.feign;

import com.Article.Article.dto.ArticleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "comment",                 // logical name
        url = "http://localhost:9090",
        path="comment"// port where author-service runs
)
public interface FeignComments {
    @PostMapping("/create")
    void createCommentsRecord(@RequestBody ArticleDTO articleDTO);
}
