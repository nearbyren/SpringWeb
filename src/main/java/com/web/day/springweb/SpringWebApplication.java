package com.web.day.springweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.web.day.springweb.mapper")
public class SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }

}
