package com.shareIt.oss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * File storage service
 *
 * @author Liu Tongxun
 * @date 2025/06/30
 */
@Service
public class FileService {

    private final StorageService storageService;

    public FileService(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * list all buckets
     */
    public List<String> getAllBucket() {
        return storageService.getAllBuckets();
    }


}

