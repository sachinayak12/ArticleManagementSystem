package com.Author.Author.Service;


import com.Author.Author.Entity.AuthorEntity;
import com.Author.Author.Repository.AuthorRepo;
import com.Author.Author.dto.ArticleDTO;
import com.Author.Author.dto.AuthorDTO;
import com.Author.Author.exceptionHandling.AuthorNotFoundException;
import com.Author.Author.exceptionHandling.OperationFailedException;
import com.Author.Author.exceptionHandling.ResourceNotFoundException;
import com.Author.Author.feign.ArticleFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    ArticleFeign articleRepo;
    @Autowired
    ArticleFeign articleClient;

//Creating  a new Author
public AuthorEntity saveAuthor(AuthorEntity author) {
    if (author == null) {
        throw new IllegalArgumentException("Author cannot be null");
    }

    try {
        return authorRepo.save(author);
    } catch (Exception e) {
        throw new RuntimeException("Error while saving author", e);
    }
}


    public List<AuthorEntity> getAllAuthors() {
        try {
            List<AuthorEntity> list = authorRepo.findAll();

            // Rare case: repo returns NULL
            if (list == null) {
                throw new RuntimeException("Repository returned null instead of list.");
            }

            return list;
        } catch (Exception ex) {
            throw new RuntimeException("Error while fetching authors", ex);
        }
    }



    public AuthorEntity findById(Long authorId) {
        try{
            return authorRepo.findByAuthorId(authorId);
        }
        catch (Exception e)
        {
            throw new AuthorNotFoundException("Author not found");
        }

    }


//    public ArticleDTO saveAuthorArticles(String authorName, ArticleDTO article) {
//
//        AuthorEntity author = findByName(authorName);
//
//        // link both sides
//        article.setAuthor(author);              // owning side
//
//        return articleRepo.save(article);
//    }

    public AuthorDTO getAuthorWithArticles(Long authorId) {

        AuthorEntity author = authorRepo.findByAuthorId(authorId);
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + authorId + " not found");
        }

        List<ArticleDTO> articles;
        try {
            articles = articleClient.getArticlesByAuthorId(authorId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch articles from Article Service");
        }

        AuthorDTO response = new AuthorDTO();
        response.setAuthorId(author.getAuthorId());
        response.setAuthorName(author.getAuthorName());
        response.setArticles(articles);

        return response;
    }

    public AuthorEntity updateName(Long authorId, String newName) {

        AuthorEntity author = authorRepo.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + authorId));

        author.setAuthorName(newName);

        try {
            return authorRepo.save(author);
        } catch (Exception e) {
            throw new RuntimeException("Error updating author name", e);
        }
    }


    public AuthorEntity updatePassword(Long authorId, String newPassword) {
        AuthorEntity author = findById(authorId); // already throws if not found

        try {
            author.setPassword(newPassword); // In real apps → encode password
            return authorRepo.save(author);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update password", e);
        }
    }

    public void deleteAuthor(Long authorId) {

        AuthorEntity authorEntity = authorRepo.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + authorId));

        try {
            authorRepo.delete(authorEntity);
        } catch (Exception e) {
            throw new OperationFailedException("Failed to delete author due to server error");
        }
    }

}
