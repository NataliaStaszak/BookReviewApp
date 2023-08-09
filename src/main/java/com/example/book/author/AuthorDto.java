package com.example.book.author;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthorDto {
    private Long id;
    @NotNull
    @Size(min = 2)
    private String name;
    @NotNull
    @Size(min = 2)
    private String surname;

    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
