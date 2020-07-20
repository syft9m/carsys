package com.jike.carsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jike.carsys.dao")
public class CarsysApplication {

    public static void main(String[] args) {
        SpringApplication.run( CarsysApplication.class, args );
    }

}
