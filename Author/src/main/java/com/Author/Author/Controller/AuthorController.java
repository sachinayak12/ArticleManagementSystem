package com.Author.Author.Controller;
import java.util.*;

import com.Author.Author.Entity.AuthorEntity;
import com.Author.Author.Mapper.AuthorMapper;
import com.Author.Author.Service.AuthorService;
import com.Author.Author.dto.AuthorCreateDTO;
import com.Author.Author.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@CrossOrigin(
//        origins = "http://localhost:4200",
//        allowedHeaders = "*",
//        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE}
//)



@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping
    public ResponseEntity<?> saveAuthor(@Valid @RequestBody AuthorEntity author) {
        AuthorEntity savedAuthor = authorService.saveAuthor(author);
        AuthorCreateDTO dto = AuthorMapper.toCreateDTO(savedAuthor);
        return ResponseEntity.ok(dto);
    }



    @GetMapping("/get")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorEntity> authors = authorService.getAllAuthors();

        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build();   // 204 NO CONTENT
        }

        List<AuthorDTO> dtoList = authors.stream()
                .map(AuthorMapper::toDTO)
                .toList();

        return ResponseEntity.ok(dtoList);
    }


    @GetMapping("/{authorId}")
    public AuthorDTO getAuthorDetails(@PathVariable Long authorId) {
        return authorService.getAuthorWithArticles(authorId);
    }


    @PatchMapping("/name/{authorId}")
    public ResponseEntity<AuthorDTO> updateAuthorName(
            @PathVariable Long authorId,
            @RequestBody Map<String, String> request) {

        String newName = request.get("newName");

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("New name cannot be empty");
        }

        AuthorEntity updatedAuthor = authorService.updateName(authorId, newName);

        return ResponseEntity.ok(AuthorMapper.toDTO(updatedAuthor));
    }



    @PatchMapping("/password/{authorId}")
    public ResponseEntity<AuthorDTO> updateAuthorPassword(
            @PathVariable Long authorId,
            @RequestBody Map<String, String> request) {

        String newPassword = request.get("newPassword");

        if (newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("New password cannot be empty");
        }

        AuthorEntity updatedAuthor = authorService.updatePassword(authorId, newPassword);

        return ResponseEntity.ok(AuthorMapper.toDTO(updatedAuthor));
    }


    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<Map<String, String>> deleteAuthor(@PathVariable Long authorId) {

        authorService.deleteAuthor(authorId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Author deleted successfully");
        response.put("authorId", String.valueOf(authorId));

        return ResponseEntity.ok(response);
    }



}
