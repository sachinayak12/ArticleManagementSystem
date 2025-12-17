package com.Article.Article.exceptionHandling;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String errorSavingArticle, Exception e) {
    }
}
