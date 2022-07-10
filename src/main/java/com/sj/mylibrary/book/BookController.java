package com.sj.mylibrary.book;

import com.sj.mylibrary.book.Entity.Book;
import com.sj.mylibrary.book.Entity.UserBook;
import com.sj.mylibrary.user.UserService;
import com.sj.mylibrary.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;
    private final UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        User user = new User("SJ");
        userService.join(user);
        Book book = bookService.searchRequestForApi("Apple").get(0);
        userService.enrollBook(user,book);
        return "OK";
    }
}
