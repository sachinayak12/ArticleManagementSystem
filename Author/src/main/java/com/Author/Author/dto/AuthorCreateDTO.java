package com.Author.Author.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthorCreateDTO {

    private String authorName;

    private String password;
}
