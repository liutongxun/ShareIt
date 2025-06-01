package com.shareIt.subject.infra.basic.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Subject-Category-Label Mapping Entity (SubjectMapping)
 *
 * Represents the mapping relationship between questions (subjects), categories, and labels.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public class SubjectMapping implements Serializable {
    private static final long serialVersionUID = -72034591678118838L;

    /**
     * Primary key
     */
    private Long id;

    /**
     * Question (subject) ID
     */
    private Long subjectId;

    /**
     * Category ID
     */
    private Long categoryId;

    /**
     * Label ID
     */
    private Long labelId;

    /**
     * Creator
     */
    private String createdBy;

    /**
     * Creation timestamp
     */
    private Date createdTime;

    /**
     * Updater
     */
    private String updateBy;

    /**
     * Update timestamp
     */
    private Date updateTime;

    /**
     * Deletion flag (e.g., 0 = not deleted, 1 = deleted)
     */
    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}