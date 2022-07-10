package com.sj.mylibrary.user.entity;

import com.sj.mylibrary.book.Entity.Book;
import com.sj.mylibrary.book.Entity.UserBook;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserBook> userBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }


    public void addBook(Book book){
        UserBook userBook = new UserBook();
        userBook.setUser(this);
        userBook.setBook(book);
        userBooks.add(userBook);
    }
}
