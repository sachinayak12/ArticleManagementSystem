package com.Article.Article.exceptionHandling;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg)
    {
        super(msg);
    }
}
