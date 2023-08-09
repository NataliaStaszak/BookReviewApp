package com.example.book.author;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthorSaveDto {
    @NotNull(message = "name cannot be empty")
    @Size(min=2,message = "name too short")
    private String name;
    @NotNull(message = "surname cannot be empty")
    @Size(min=2,message = "surname too short")
    private String surname;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
}
