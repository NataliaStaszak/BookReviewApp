package com.example.book.author;

import com.example.book.author.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorBooksDtoMapper authorBooksDtoMapper;
    private final AuthorDtoMapper authorDtoMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorBooksDtoMapper authorBookDtoMapper, AuthorDtoMapper authorDtoMapper) {
        this.authorRepository = authorRepository;
        this.authorBooksDtoMapper = authorBookDtoMapper;
        this.authorDtoMapper = authorDtoMapper;
    }
    Optional<AuthorDto> getAuthorById(Long id){
        return authorRepository.findById(id).map(authorDtoMapper::map);
    }
    List<AuthorBooksDto> getAuthorBooksByAuthorId(Long id) {
        return authorRepository.findById(id)
                .map(Author::getBooks)
                .orElse(Collections.emptyList())
                .stream()
                .map(authorBooksDtoMapper::map)
                .toList();
    }
    AuthorDto saveAuthor(AuthorSaveDto authorSaveDto){
        Author author = authorDtoMapper.map(authorSaveDto);
        Author savedAuthor = authorRepository.save(author);

        return authorDtoMapper.map(savedAuthor);
    }
}
