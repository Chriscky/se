package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        LocalDate localDate = java.time.LocalDate.now();
        System.out.println("这里"+ localDate);
        System.out.println("这里"+ localDate.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
