package com.sj.mylibrary.user;

import com.sj.mylibrary.book.BookService;
import com.sj.mylibrary.book.Entity.Book;
import com.sj.mylibrary.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BookService bookService;

    public void join(User user){
        userRepository.save(user);
    }

    @Transactional
    public void enrollBook(User user, Book book){
        bookService.addBookIfNotExist(book);
        user.addBook(book);
        userRepository.save(user);
    }
}
