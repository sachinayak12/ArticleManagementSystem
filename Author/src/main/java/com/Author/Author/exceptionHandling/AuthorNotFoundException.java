package com.Author.Author.exceptionHandling;

public class AuthorNotFoundException extends RuntimeException {


        public AuthorNotFoundException(String exceptionMESSAGE)
        {
            super(exceptionMESSAGE);
        }

}
