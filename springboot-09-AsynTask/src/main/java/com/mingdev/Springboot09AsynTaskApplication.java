package com.mingdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync //开启异步注解功能
@EnableScheduling
@SpringBootApplication
public class Springboot09AsynTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsynTaskApplication.class, args);
    }

}
