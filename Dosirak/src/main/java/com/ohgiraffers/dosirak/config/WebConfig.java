package com.ohgiraffers.dosirak.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:///C:/Dosirak/original/customer/");

        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:///C:/Dosirak/original/review/");

        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:///C:/Dosirak/original/productUpload/");


    }
}
