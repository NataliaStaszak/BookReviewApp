package com.example.book.author;

import com.example.book.author.Author;
import com.example.book.author.AuthorDto;
import org.springframework.stereotype.Service;

@Service
public class AuthorDtoMapper {
    AuthorDto map(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());


        return authorDto;
    }

    Author map(AuthorSaveDto authorSaveDto){
        Author author=new Author();
        author.setName(authorSaveDto.getName());
        author.setSurname(authorSaveDto.getSurname());

        return author;
    }
}
