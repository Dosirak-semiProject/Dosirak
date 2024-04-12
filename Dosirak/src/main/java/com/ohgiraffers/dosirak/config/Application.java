package com.ohgiraffers.dosirak.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("머지테스트123!");
        System.out.println("푸시테스트1234!");
        SpringApplication.run(Application.class, args);
    }
}
