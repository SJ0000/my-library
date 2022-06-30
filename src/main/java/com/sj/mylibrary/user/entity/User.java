package com.sj.mylibrary.user.entity;

import com.sj.mylibrary.book.Entity.Book;
import com.sj.mylibrary.book.Entity.UserBook;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String isbn;

    @OneToMany(mappedBy = "user")
    private List<UserBook> userBooks = new ArrayList<>();
}
