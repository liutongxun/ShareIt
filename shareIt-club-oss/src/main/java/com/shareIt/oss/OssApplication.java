package com.shareIt.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * OSS Service Starter
 *
 * This class serves as the entry point for initializing and launching
 * the OSS (Object Storage Service) integration within the application.
 *
 * @author Liu Tongxun
 * @date 2025/06/27
 */

@SpringBootApplication
@ComponentScan("com.shareIt")
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }

}
