package com.shareIt.oss.entity;

/**
 * File class representing a file or directory.
 *
 * This class encapsulates the information related to a file, including its name,
 * whether it is a directory, and its ETag (a unique identifier for the file).
 *
 * @author Liu Tongxun
 * @date 2025/06/27
 */
public class FileInfo {

    /**
     * The name of the file or directory.
     */
    private String fileName;

    /**
     * A flag indicating whether the item is a directory.
     * True if the item is a directory, false if it is a file.
     */
    private Boolean directoryFlag;

    /**
     * The ETag (Entity Tag) associated with the file.
     * The ETag is a unique identifier used to track the file for versioning and caching purposes.
     */
    private String etag;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getDirectoryFlag() {
        return directoryFlag;
    }

    public void setDirectoryFlag(Boolean directoryFlag) {
        this.directoryFlag = directoryFlag;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
