package com.example.book.author;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthorBooksDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 3)
    private String description;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
