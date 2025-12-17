package com.Article.Article.Controller;

import com.Article.Article.Entity.ArticleEntity;

import com.Article.Article.Mapper.ArticleMapper;
import com.Article.Article.Service.ArticleService;
import com.Article.Article.dto.ArticleDTO;
import com.Article.Article.exceptionHandling.ArticleNotFoundException;
import com.Article.Article.exceptionHandling.DatabaseException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("article")
//@CrossOrigin(origins = "http://localhost:4200")

public class ArticleController {
    @Autowired
    ArticleService  articleService;



    @PostMapping("/save")
    public ResponseEntity<ArticleDTO> saveArticle(@RequestBody ArticleDTO articleDTO)  {
        ArticleEntity savedArticle = articleService.save(articleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ArticleMapper.toDTO(savedArticle));
    }




    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long articleId) {
        if(articleService.deleteArticle(articleId))
            return ResponseEntity.ok("Article deleted successfully");
        return ResponseEntity.status(400).body("Failed in deleting the article");
    }


    @GetMapping("/get/{authorId}")
    public ResponseEntity<List<ArticleDTO>> getArticles(@PathVariable Long authorId)
    {

          return  articleService.getArticles(authorId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }


    @PatchMapping("/update")
    public ResponseEntity<ArticleDTO> updateAuthorArticles(@RequestBody ArticleDTO articleDTO) {

        ArticleEntity updated = articleService.updateArticle(
                articleDTO.getAuthorId(),
                articleDTO.getArticleName(),
                articleDTO.getArticleDescription()
        );

        return ResponseEntity.ok(ArticleMapper.toDTO(updated));
    }


}
