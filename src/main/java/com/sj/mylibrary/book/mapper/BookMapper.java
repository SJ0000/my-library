package com.sj.mylibrary.book.mapper;

import com.sj.mylibrary.book.Entity.Book;
import com.sj.mylibrary.book.dto.BookSearchApiResponseDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {
    default List<Book> bookSearchApiResponseDtoToBooks(BookSearchApiResponseDto dto){

        return dto.getDocuments().stream()
                .map(document ->{
                    String name = document.getTitle();
                    String author = document.getAuthors()[0];
                    String isbn = document.parseIsbn();
                    String imagePath = document.getThumbnail();
                    return new Book(name,author,isbn,imagePath);
                })
                .collect(Collectors.toList());
    }
}
