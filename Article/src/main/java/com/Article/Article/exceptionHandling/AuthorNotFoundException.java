package com.Article.Article.exceptionHandling;

public class AuthorNotFoundException extends RuntimeException {


        public AuthorNotFoundException(String exceptionMESSAGE)
        {
            super(exceptionMESSAGE);
        }

}
