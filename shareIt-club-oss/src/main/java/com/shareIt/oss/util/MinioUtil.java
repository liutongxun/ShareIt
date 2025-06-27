package com.shareIt.oss.util;

import com.shareIt.oss.entity.FileInfo;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Minio File Operation Utility
 *
 * This class provides utility methods to interact with the Minio object storage service.
 * It includes operations like creating buckets, uploading and downloading files,
 * listing buckets, and generating presigned URLs for file access.
 *
 * @author Liu Tongxun
 * @date 2025/06/27
 */
@Component
public class MinioUtil {

    @Resource
    private MinioClient minioClient;

    /**
     * Creates a new bucket if it does not already exist.
     *
     * This method checks if the specified bucket exists. If it doesn't,
     * it will create a new one.
     *
     * @param bucket The name of the bucket to be created.
     * @throws Exception If there is any issue during bucket creation.
     */
    public void createBucket(String bucket) throws Exception {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
    }

    /**
     * Uploads a file to the specified bucket.
     *
     * This method uploads the given InputStream to the specified bucket
     * with the specified object name.
     *
     * @param inputStream The InputStream of the file to be uploaded.
     * @param bucket The name of the bucket to upload the file to.
     * @param objectName The name of the object (file) to store in the bucket.
     * @throws Exception If there is any issue during the file upload.
     */
    public void uploadFile(InputStream inputStream, String bucket, String objectName) throws Exception {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucket).object(objectName)
                .stream(inputStream, -1, 5242889L).build());
    }

    /**
     * Lists all available buckets in the Minio server.
     *
     * This method fetches all the buckets and returns their names in a list.
     *
     * @return List<String> A list of all bucket names.
     * @throws Exception If there is any issue while listing the buckets.
     */
    public List<String> getAllBuckets() throws Exception {
        List<Bucket> buckets = minioClient.listBuckets();
        return buckets.stream().map(Bucket::name).collect(Collectors.toList());
    }

    /**
     * Lists all files in the specified bucket.
     *
     * This method retrieves all the objects in the given bucket and creates a list of FileInfo objects,
     * each representing a file or directory within the bucket. The list includes the file's name,
     * whether it is a directory, and its ETag (a unique identifier for the file).
     *
     * @param bucket The name of the bucket whose files are to be listed.
     * @return A list of FileInfo objects containing information about each file or directory in the bucket.
     * @throws Exception If there is an error while fetching the objects from the Minio server.
     */
    public List<FileInfo> getAllFile(String bucket) throws Exception {
        // Retrieve all objects from the specified bucket
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucket).build());

        // Initialize a list to hold file information
        List<FileInfo> fileInfoList = new LinkedList<>();

        // Loop through the results and populate the fileInfoList
        for (Result<Item> result : results) {
            FileInfo fileInfo = new FileInfo();
            Item item = result.get();

            // Set file information
            fileInfo.setFileName(item.objectName()); // Set file/directory name
            fileInfo.setDirectoryFlag(item.isDir()); // Set whether it's a directory
            fileInfo.setEtag(item.etag()); // Set the ETag for the file

            // Add file information to the list
            fileInfoList.add(fileInfo);
        }

        // Return the list of file information
        return fileInfoList;
    }

    /**
     * Downloads a file from the specified bucket.
     *
     * This method retrieves the file from the specified bucket and object name.
     *
     * @param bucket The name of the bucket.
     * @param objectName The name of the object (file).
     * @return InputStream The InputStream of the downloaded file.
     * @throws Exception If there is any issue during the file download.
     */
    public InputStream downLoad(String bucket, String objectName) throws Exception {
        return minioClient.getObject(
                GetObjectArgs.builder().bucket(bucket).object(objectName).build()
        );
    }

    /**
     * Deletes a bucket from the Minio server.
     *
     * This method removes the specified bucket. All objects within the bucket
     * should be deleted before removing the bucket itself.
     *
     * @param bucket The name of the bucket to be deleted.
     * @throws Exception If there is any issue during bucket deletion.
     */
    public void deleteBucket(String bucket) throws Exception {
        minioClient.removeBucket(
                RemoveBucketArgs.builder().bucket(bucket).build()
        );
    }



    /**
     * Deletes a file (object) from the specified bucket.
     *
     * This method removes the object from the specified bucket.
     *
     * @param bucket The name of the bucket.
     * @param objectName The name of the object (file) to be deleted.
     * @throws Exception If there is any issue during the file deletion.
     */
    public void deleteObject(String bucket, String objectName) throws Exception {
        minioClient.removeObject(
                RemoveObjectArgs.builder().bucket(bucket).object(objectName).build()
        );
    }

    /**
     * Generates a presigned URL for accessing a file in a bucket.
     *
     * This method generates a presigned URL to allow temporary access to the object
     * in the specified bucket. The generated URL can be used to download the file.
     *
     * @param bucketName The name of the bucket containing the object.
     * @param objectName The name of the object (file) to generate the URL for.
     * @return String The presigned URL to access the object.
     * @throws Exception If there is any issue generating the presigned URL.
     */
    public String getPreviewFileUrl(String bucketName, String objectName) throws Exception{
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(bucketName).object(objectName).build();
        return minioClient.getPresignedObjectUrl(args);
    }
}
