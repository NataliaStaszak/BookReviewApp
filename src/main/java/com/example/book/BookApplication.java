package com.example.book;

import com.example.book.author.Author;
import com.example.book.author.AuthorDto;
import com.example.book.author.AuthorRepository;
import com.example.book.author.AuthorService;
import com.example.book.book.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookApplication.class, args);

    }

}
