package com.shareIt.oss.adapter;

import com.shareIt.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * File Storage Adapter Interface
 *
 * This interface defines the operations that any file storage service adapter (e.g., Aliyun, MiniIO)
 * should implement. It provides methods for interacting with file storage services, such as creating
 * buckets, uploading files, listing buckets and files, downloading files, and deleting objects.
 *
 * @author Liu Tongxun
 * @date 2025/07/01
 */
public interface StorageAdapter {

    /**
     * Creates a new bucket.
     *
     * @param bucket The name of the bucket to be created.
     */
    void createBucket(String bucket);

    /**
     * Uploads a file to the specified bucket.
     *
     * @param uploadFile The file to be uploaded.
     * @param bucket The bucket to upload the file to.
     * @param objectName The name of the object in the bucket.
     */
    void uploadFile(MultipartFile uploadFile, String bucket, String objectName);

    /**
     * Lists all available buckets.
     *
     * @return A list of bucket names.
     */
    List<String> getAllBucket();

    /**
     * Lists all files in the specified bucket.
     *
     * @param bucket The name of the bucket.
     * @return A list of file information in the specified bucket.
     */
    List<FileInfo> getAllFile(String bucket);

    /**
     * Downloads a file from the specified bucket.
     *
     * @param bucket The name of the bucket.
     * @param objectName The name of the file to be downloaded.
     * @return An InputStream of the file data.
     */
    InputStream downLoad(String bucket, String objectName);

    /**
     * Deletes a bucket.
     *
     * @param bucket The name of the bucket to be deleted.
     */
    void deleteBucket(String bucket);

    /**
     * Deletes a file from the specified bucket.
     *
     * @param bucket The name of the bucket.
     * @param objectName The name of the file to be deleted.
     */
    void deleteObject(String bucket, String objectName);

    /**
     * Gets the URL for accessing a file in the specified bucket.
     *
     * @param bucket The name of the bucket.
     * @param objectName The name of the file.
     * @return The URL of the file.
     */
    String getUrl(String bucket, String objectName);
}

