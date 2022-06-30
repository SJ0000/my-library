package com.sj.mylibrary.book.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private String isbn10;
    private String isbn13;
    private String imagePath;

    @OneToMany(mappedBy = "book")
    List<UserBook> userBooks = new ArrayList<>();
}
