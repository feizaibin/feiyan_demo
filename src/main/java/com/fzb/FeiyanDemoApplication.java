package com.fzb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fzb.mapper")
public class FeiyanDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeiyanDemoApplication.class, args);
    }

}
