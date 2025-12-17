package com.Article.Article.exceptionHandling;

import java.io.FileNotFoundException;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String message)
    {
        super(message);
    }
}
