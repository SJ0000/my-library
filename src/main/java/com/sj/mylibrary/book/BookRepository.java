package com.sj.mylibrary.book;

import com.sj.mylibrary.book.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
