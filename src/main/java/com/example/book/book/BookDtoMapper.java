package com.example.book.book;

import com.example.book.author.Author;
import com.example.book.author.AuthorDto;
import com.example.book.author.AuthorRepository;
import com.example.book.author.AuthorSaveDto;
import com.example.book.book.Book;
import com.example.book.book.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookDtoMapper {
    AuthorRepository authorRepository;

    public BookDtoMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    BookDto map(Book book){
        BookDto bookDto=new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setDescription(book.getDescription());
        bookDto.setAuthorName(book.getAuthor().getName() + " " + book.getAuthor().getSurname());

        return bookDto;
    }
    Book map(BookSaveDto bookSaveDto){
        Book book=new Book();
        book.setName(bookSaveDto.getName());
        book.setDescription(bookSaveDto.getDescription());
        Author author = authorRepository.findById(bookSaveDto.getAuthorId()).orElseThrow();
        book.setAuthor(author);

        return book;
    }
}
