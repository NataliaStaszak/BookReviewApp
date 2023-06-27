package com.example.book.book;

import com.example.book.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    }

