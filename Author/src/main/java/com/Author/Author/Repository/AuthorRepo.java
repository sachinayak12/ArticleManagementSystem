package com.Author.Author.Repository;

import com.Author.Author.Entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity,Long> {
    AuthorEntity findByAuthorName(String authorName);
    AuthorEntity findByAuthorId(Long authorId);


}
