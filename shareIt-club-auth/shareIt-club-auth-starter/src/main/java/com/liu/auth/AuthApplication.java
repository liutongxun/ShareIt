package com.liu.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Flashcard Microservice Startup Class
 *
 * @author: Liu Tongxun
 * @date: 21/07/2025
 */
@SpringBootApplication
@ComponentScan("com.liu")
//@MapperScan("com.liu.**.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

}
