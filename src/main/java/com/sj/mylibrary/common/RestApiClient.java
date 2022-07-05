package com.sj.mylibrary.common;

import com.sj.mylibrary.book.dto.BookSearchApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestApiClient {
    private final RestTemplateBuilder restTemplateBuilder;
    @Value("${kakao-open-api.rest-api-key}")
    private String apiKey;

    public BookSearchApiResponseDto request(String title){
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponents uri = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("dapi.kakao.com")
                .path("/v3/search/book")
                .queryParam("query",title)
                .queryParam("target","title")
                .encode()
                .build();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri.toUri())
                .header("Authorization", "KakaoAK " + apiKey)
                .build();

        ResponseEntity<BookSearchApiResponseDto> response = restTemplate.exchange(requestEntity, BookSearchApiResponseDto.class);
        return response.getBody();
    }
}
