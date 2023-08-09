package com.example.book.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



public class BookSaveDto {
    @NotNull(message = "title cannot be empty")
    private String name;
    @NotNull(message = "description cannot be empty")
    @Size(min = 3,message = "description too short")
    private String description;
    @NotNull
    @Positive(message = "wrong id")
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
