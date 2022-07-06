package com.sj.mylibrary.book.Entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private String isbn;
    private String imagePath;

    public Book(String name, String author, String isbn, String imagePath) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.imagePath = imagePath;
    }
}
