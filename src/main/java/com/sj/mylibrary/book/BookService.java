package com.sj.mylibrary.book;

import com.sj.mylibrary.book.Entity.Book;
import com.sj.mylibrary.book.dto.BookSearchApiResponseDto;
import com.sj.mylibrary.book.mapper.BookMapper;
import com.sj.mylibrary.common.RestApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final RestApiClient restApiClient;
    private final BookMapper mapper;
    public List<Book> searchRequestForApi(String title){
        BookSearchApiResponseDto response = restApiClient.request(title);
        return mapper.bookSearchApiResponseDtoToBooks(response);
    }

    public Book findByIsbn(String isbn){
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        return optionalBook.orElseThrow(() -> new RuntimeException("Book not exist"));
    }

    public void addBookIfNotExist(Book book){
        Optional<Book> optionalBook = bookRepository.findByIsbn(book.getIsbn());
        if(optionalBook.isEmpty()){
            bookRepository.save(book);
        }
    }
}
