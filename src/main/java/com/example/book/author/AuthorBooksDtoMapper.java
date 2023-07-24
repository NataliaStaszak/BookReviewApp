package com.example.book.author;

import com.example.book.author.AuthorBooksDto;
import com.example.book.book.Book;
import org.springframework.stereotype.Service;

@Service
public class AuthorBooksDtoMapper {
    AuthorBooksDto map(Book book){
        AuthorBooksDto authorDto=new AuthorBooksDto();
        authorDto.setId(book.getId());
        authorDto.setName(book.getName());
        authorDto.setDescription(book.getDescription());
        return authorDto;

    }
}
