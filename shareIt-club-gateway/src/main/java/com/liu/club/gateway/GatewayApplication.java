package com.liu.club.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Gateway Starter
 *
 * @author Liu Tongxun
 * @date 2025/07/22
 */
@SpringBootApplication
@ComponentScan("com.liu")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }

}
