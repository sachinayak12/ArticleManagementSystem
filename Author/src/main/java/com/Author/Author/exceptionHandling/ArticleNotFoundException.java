package com.Author.Author.exceptionHandling;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String message)
    {
        super(message);
    }
}
