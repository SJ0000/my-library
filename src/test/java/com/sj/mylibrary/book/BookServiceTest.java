package com.sj.mylibrary.book;

import com.sj.mylibrary.book.Entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class BookServiceTest {

    @Autowired BookService bookService;

    @Test
    void searchByTitle() {
        List<Book> result = bookService.searchRequestForApi("DOG");

        for(Book book : result){
            log.info("book = {} {} {} {}",book.getName(),book.getAuthor(),book.getIsbn(),book.getImagePath());
        }
    }
}