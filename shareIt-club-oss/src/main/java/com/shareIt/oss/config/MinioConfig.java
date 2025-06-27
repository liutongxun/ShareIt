package com.shareIt.oss.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Minio Configuration Management
 *
 * This class is responsible for configuring and initializing the Minio client
 * by loading required properties like the Minio URL, access key, and secret key
 * from the application's configuration file.
 *
 * The `MinioClient` bean is created to interact with the Minio object storage service.
 *
 * @author Liu Tongxun
 * @date 2025/06/27
 */
@Configuration
public class MinioConfig {

    /**
     * Minio URL
     * The URL of the Minio server, used to connect to the object storage service.
     */
    @Value("${minio.url}")
    private String url;

    /**
     * Minio Access Key
     * The access key for authenticating with Minio.
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * Minio Secret Key
     * The secret key for authenticating with Minio.
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * Creates and configures the MinioClient bean.
     *
     * This method initializes the MinioClient using the configured URL, access key, and secret key.
     * It returns a `MinioClient` instance that can be used to interact with Minio storage.
     *
     * @return MinioClient The configured Minio client.
     */
    @Bean
    public MinioClient getMinioClient() {
        return MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
    }


}
