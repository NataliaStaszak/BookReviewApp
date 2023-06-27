package com.example.book.book;

import com.example.book.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>  {

}
