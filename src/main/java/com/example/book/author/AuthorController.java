package com.example.book.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/authors/{id}")
    ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/authors/{id}/books")
    ResponseEntity <List<AuthorBooksDto>> getAuthorBooks(@PathVariable Long id) {
        if (authorService.getAuthorById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authorService.getAuthorBooksByAuthorId(id));
    }
}
