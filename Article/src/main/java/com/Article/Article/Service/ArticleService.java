package com.Article.Article.Service;

import com.Article.Article.Entity.ArticleEntity;
import com.Article.Article.Mapper.ArticleMapper;
import com.Article.Article.Repository.ArticleRepo;

import com.Article.Article.dto.ArticleDTO;
import com.Article.Article.dto.AuthorCreateDTO;
import com.Article.Article.dto.AuthorDTO;
import com.Article.Article.dto.LikesDTO;
import com.Article.Article.exceptionHandling.ArticleNotFoundException;
import com.Article.Article.exceptionHandling.AuthorNotFoundException;
import com.Article.Article.exceptionHandling.DatabaseException;
import com.Article.Article.feign.FeignAuthor;
import com.Article.Article.feign.FeignComments;
import com.Article.Article.feign.FeignInteraction;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ArticleService {
    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    FeignAuthor authorFeign;

    @Autowired
    FeignInteraction feignInteraction;
    @Autowired
    FeignComments feignComments;

    public ArticleEntity save(ArticleDTO articleDTO){
        try {
            if (null!= articleDTO) {
                ArticleEntity entity = ArticleMapper.toEntity(articleDTO);
                ArticleEntity article = articleRepo.save(entity);
//                feignInteraction.createInteractionRecord(ArticleMapper.toDTO(article));
//                feignComments.createCommentsRecord(ArticleMapper.toDTO(article));
                return article;

            }
        }catch(Exception e) {
                log.info("Error while save to the data base , {}" , e);
            }
        return null;
    }

    @Transactional
    public boolean deleteArticle(Long id) {

        try{
            if(null != id)
            {
                ArticleDTO articleDTO = ArticleMapper.toDTO(articleRepo.findByArticleId(id));
                if (null != articleDTO) {
                    int deletedCount = articleRepo.deleteByArticleId(id);
                    if(deletedCount==1)
                        return true;
                }
            }
        }
        catch (Exception e) {
            log.info("Error while deleting the data,{}");
        }
        return false;
    }


    @Transactional
    public ArticleEntity updateArticle(Long authorId, String articleName, String newDescription) {
        try{
            ArticleEntity article = articleRepo.findByAuthorIdAndArticleName(authorId, articleName);

            if (null !=article) {
                article.setArticleDescription(newDescription);
                return articleRepo.save(article);
            }
        }
        catch(Exception e)
        {
            log.info("Error while updating the article,{}",e);
        }
    return null;

    }



    public ResponseEntity<List<ArticleDTO>> getArticles(Long authorId) {
        if(null!=authorId && authorId!=0) {
            List<ArticleEntity> articleEntities = articleRepo.findByAuthorId(authorId);
            if (null != articleEntities) {
                return ResponseEntity.ok(articleEntities.stream()
                        .map(ArticleMapper::toDTO)
                        .collect(Collectors.toList()));
            }
        }
        return null;

    }



//    public List<ArticleDTO> getAllArticles() {
//        try {
//            List<ArticleEntity> articles = articleRepo.findAll();
//
//            List<LikesDTO> likesList = feignInteraction.getAllLikes();
//
//            Map<Long, Long> likesMap = likesList.stream()
//                    .collect(Collectors.toMap(
//                            LikesDTO::getArticleId,
//                            LikesDTO::getLikes,
//                            (a, b) -> a   // if duplicates exist
//                    ));
//
//            return articles.stream()
//                    .map(article -> {
//                        ArticleDTO dto = ArticleMapper.toDTO(article);
//                        dto.setLikes(likesMap.getOrDefault(article.getArticleId(), 0L));
//                        return dto;
//                    })
//                    .collect(Collectors.toList());
//
//        } catch (Exception e) {
//            log.error("Error while fetching articles", e);
//            return new ArrayList<>();   //  Instead of null
//        }
//    }

    public List<ArticleDTO> getAllArticles() {
        List<ArticleEntity> articles = articleRepo.findAll();
        List<LikesDTO> likesList = feignInteraction.getAllLikes();

        Map<Long, Long> likesMap = likesList.stream()
                .collect(Collectors.toMap(
                        LikesDTO::getArticleId,
                        LikesDTO::getLikes
                ));

        return articles.stream().map(article -> {
            ArticleDTO dto = ArticleMapper.toDTO(article);
            dto.setLikes(likesMap.getOrDefault(article.getArticleId(), 0L));
            return dto;
        }).collect(Collectors.toList());
    }



}



