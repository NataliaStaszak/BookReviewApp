package com.example.book.book;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Optional;


@Service
public class BookService {
    private BookRepository bookRepository;
    private BookDtoMapper bookDtoMapper;


    public BookService(BookRepository bookRepository, BookDtoMapper bookDtoMapper, Validator validator) {
        this.bookRepository = bookRepository;
        this.bookDtoMapper = bookDtoMapper;
    }
    Optional<BookDto> getBookById(Long id){
        return bookRepository.findById(id).map(bookDtoMapper::map);
    }
    BookDto saveBook(BookSaveDto bookSaveDto){
        Book book = bookDtoMapper.map(bookSaveDto);
        Book savedBook = bookRepository.save(book);

        return bookDtoMapper.map(savedBook);

    }
    void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
