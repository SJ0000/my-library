package com.sj.mylibrary.book.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BookSearchApiResponseDto {

    private Meta meta;
    private List<Document> documents;

    @Getter
    @Setter
    @ToString
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Meta{
        Integer totalCount;
        Integer pageable_count;
        Boolean is_end;
    }

    @Getter
    @Setter
    @ToString
    public static class Document{
        private String title;
        private String contents;
        private String url;
        private String isbn;

        @JsonProperty("datetime")
        private String dateTime;

        private String[] authors;
        private String publisher;
        private String[] translators;
        private Integer price;

        @JsonProperty("sale_price")
        private Integer salePrice;
        private String thumbnail;
        private String status;
    }
}
