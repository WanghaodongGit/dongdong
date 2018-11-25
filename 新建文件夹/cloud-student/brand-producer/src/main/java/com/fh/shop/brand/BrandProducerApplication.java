package com.fh.shop.brand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fh.shop.brand.mapper")
public class BrandProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrandProducerApplication.class, args);
    }
}
