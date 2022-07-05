package com.sj.mylibrary;

import com.sj.mylibrary.book.dto.BookSearchApiResponseDto;
import com.sj.mylibrary.common.RestApiClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ConfigTest {

    @Autowired
    RestApiClient restApiClient;

    @Test
    void test(){
        BookSearchApiResponseDto dog = restApiClient.request("dog");
        log.info("dog = {}",dog);
    }
}
