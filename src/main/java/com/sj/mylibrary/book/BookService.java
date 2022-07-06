package com.sj.mylibrary.book;

import com.sj.mylibrary.book.Entity.Book;
import com.sj.mylibrary.book.dto.BookSearchApiResponseDto;
import com.sj.mylibrary.book.mapper.BookMapper;
import com.sj.mylibrary.common.RestApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final RestApiClient restApiClient;
    private final BookMapper mapper;
    public List<Book> searchByTitle(String title){
        BookSearchApiResponseDto response = restApiClient.request(title);
        return mapper.bookSearchApiResponseDtoToBooks(response);
    }
}
