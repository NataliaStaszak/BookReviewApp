package com.example.book.author;

import com.example.book.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.jdi.TypeComponent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2)
    private String name;
    @NotNull
    @Size(min=2)
    private String surname;
    @OneToMany(mappedBy = "author",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public Author(){}

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
