package com.example.book.book;

import com.example.book.author.AuthorDto;
import com.example.book.author.AuthorSaveDto;
import com.example.book.author.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<BookDto> GetById(@PathVariable Long id){
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<BookDto> saveBook(@Valid @RequestBody BookSaveDto bookSaveDto){
        BookDto savedBook = bookService.saveBook(bookSaveDto);
        URI savedAuthorUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();
        return ResponseEntity.created(savedAuthorUri).body(savedBook);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }


    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }



    }

