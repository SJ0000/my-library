package com.sj.mylibrary.book;

import com.sj.mylibrary.book.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select b from Book b where b.isbn = :isbn")
    Optional<Book> findByIsbn(String isbn);
}
