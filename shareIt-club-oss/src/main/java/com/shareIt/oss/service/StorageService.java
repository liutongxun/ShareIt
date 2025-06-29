package com.shareIt.oss.service;

import com.shareIt.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * This interface defines the operations for file storage services, including
 * creating and deleting buckets, uploading and downloading files, and managing
 * files within buckets. It provides basic methods for interacting with a file
 * storage system.
 *
 * @author Liu Tongxun
 * @date 2025/06/29
 */
public interface StorageService {

    /**
     * Create a bucket
     */
    void createBucket(String bucket);

    /**
     * Upload a file
     */
    void uploadFile(MultipartFile uploadFile, String bucket, String objectName);

    /**
     * List all buckets
     */
    List<String> getAllBuckets();

    /**
     * List all files in the specified bucket
     */
    List<FileInfo> getAllFile(String bucket);

    /**
     * Download a file
     */
    InputStream downLoad(String bucket, String objectName);

    /**
     * Delete a bucket
     */
    void deleteBucket(String bucket);

    /**
     * Delete a file
     */
    void deleteObject(String bucket, String objectName);

    /**
     * Get the URL of the file in the specified bucket
     */
    String getUrl(String bucket, String objectName);

}
