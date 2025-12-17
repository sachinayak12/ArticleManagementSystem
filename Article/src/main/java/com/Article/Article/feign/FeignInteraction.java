package com.Article.Article.feign;

import com.Article.Article.dto.ArticleDTO;
import com.Article.Article.dto.LikesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "interaction",                 // logical name
        url = "http://localhost:9999",
        path="likes"// port where author-service runs
)
public interface FeignInteraction {

    @PostMapping("/create")
    void createInteractionRecord(@RequestBody ArticleDTO articleId);

    @GetMapping("/getAll")
    List<LikesDTO> getAllLikes();


}

