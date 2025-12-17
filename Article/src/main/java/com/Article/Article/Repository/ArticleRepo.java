package com.Article.Article.Repository;

import com.Article.Article.Entity.ArticleEntity;
import com.Article.Article.dto.ArticleDTO;
import com.Article.Article.dto.AuthorDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleEntity , Long> {
    @Modifying
    @Transactional
    int deleteByArticleNameAndAuthorId(String articleName, Long authorId);
    ArticleEntity findByAuthorIdAndArticleName( Long authorId , String articleName);




    ArticleEntity findByArticleId(Long authorId);

    int deleteByArticleId(Long id);

    List<ArticleEntity> findByAuthorId(Long authorId);


//    ArticleDTO updateArticleByArticleNameAndAuthorId(String articleName, Long authorId, ArticleEntity articleEntity);
}
