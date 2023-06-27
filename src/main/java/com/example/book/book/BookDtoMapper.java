package com.example.book.book;

import com.example.book.book.Book;
import com.example.book.book.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookDtoMapper {
    BookDto map(Book book){
        BookDto bookDto=new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setDescription(book.getDescription());
        bookDto.setAuthorName(book.getAuthor().getName() + " " + book.getAuthor().getSurname());

        return bookDto;
    }
}
