package com.example.book.author;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/authors")
    ResponseEntity<AuthorDto> saveAuthor(@Valid @RequestBody AuthorSaveDto authorSaveDto){
        AuthorDto savedAuthor = authorService.saveAuthor(authorSaveDto);
        URI savedAuthorUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAuthor.getId())
                .toUri();
        return ResponseEntity.created(savedAuthorUri).body(savedAuthor);

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }
    @PutMapping("/authors/{id}")
    ResponseEntity<?> replaceAuthor(@PathVariable Long id, @RequestBody AuthorSaveDto author) {
        return authorService.replaceAuthor(id, author)
                .map(c -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/authors/{id}")
    ResponseEntity<?> deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

}
