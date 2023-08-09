package com.example.book.book;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 3)
    private String description;
    private String authorName;

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
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
