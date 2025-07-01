package com.shareIt.oss.config;


import com.shareIt.oss.adapter.AliStorageAdapter;
import com.shareIt.oss.adapter.MinioStorageAdapter;
import com.shareIt.oss.adapter.StorageAdapter;
import com.shareIt.oss.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * File storage configuration
 *
 * @author Liu Tongxun
 * @date 2025/06/30
 */
@Configuration
@RefreshScope
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;

//    @Resource
//    private StorageService minioStorageService;
//
//    @Resource
//    private StorageService aliyunStorageService;
//
//    @Bean
//    @RefreshScope
//    public StorageService storageService() {
//        if ("minio".equals(storageType)) {
//            return minioStorageService;
//        } else if ("aliyun".equals(storageType)) {
//            return aliyunStorageService;
//        } else {
//            throw new IllegalArgumentException("No corresponding file storage handler found");
//        }
//    }

    @Bean
    @RefreshScope
    public StorageAdapter storageService() {
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }

}
