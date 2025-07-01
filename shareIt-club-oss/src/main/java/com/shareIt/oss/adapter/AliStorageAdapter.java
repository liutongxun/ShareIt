package com.shareIt.oss.adapter;

import com.shareIt.oss.entity.FileInfo;
import com.shareIt.oss.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Aliyun OSS Adapter
 *
 * This class acts as an adapter to interact with the Aliyun OSS service.
 * It implements the StorageAdapter interface and delegates the file upload functionality
 * to the Aliyun OSS service.
 *
 * @author Liu Tongxun
 * @date 2025/07/01
 */

public class AliStorageAdapter implements StorageAdapter {

    @Resource
    private MinioUtil minioUtil;
    @Override
    public void createBucket(String bucket) {

    }

    @Override
    public void uploadFile(MultipartFile uploadFile, String bucket, String objectName) {

    }

    @Override
    public List<String> getAllBucket() {
        List<String> bucketNameList = new LinkedList<>();
        bucketNameList.add("aliyun");
        return bucketNameList;
    }

    @Override
    @SneakyThrows
    public List<FileInfo> getAllFile(String bucket) {
        return minioUtil.getAllFile(bucket);
    }

    @Override
    public InputStream downLoad(String bucket, String objectName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucket) {

    }

    @Override
    public void deleteObject(String bucket, String objectName) {

    }

    @Override
    public String getUrl(String bucket, String objectName) {
        return null;
    }

}
