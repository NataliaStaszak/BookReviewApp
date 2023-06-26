package com.example.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookApplication.class, args);
        BookRepository bookRepository =context.getBean(BookRepository.class);
        bookRepository.findAll().forEach(System.out::println);
    }

}
