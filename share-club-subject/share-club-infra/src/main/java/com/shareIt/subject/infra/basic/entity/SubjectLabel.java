package com.shareIt.subject.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * SubjectLabel entity class
 *
 * Represents a label used for categorizing subjects (questions).
 *
 * @author Liu Tongxun
 * @since 2025-05-31
 */
@Data
public class SubjectLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Primary key
     */
    private Long id;

    /**
     * Label name
     */
    private String labelName;

    /**
     * Category ID
     */
    private Long categoryId;

    /**
     * Sort order
     */
    private Integer sortNum;

    /**
     * Created by
     */
    private String createdBy;

    /**
     * Creation time
     */
    private Date createdTime;

    /**
     * Updated by
     */
    private String updateBy;

    /**
     * Deletion flag (e.g., 0 = not deleted, 1 = deleted)
     */
    private Integer isDeleted;

    /**
     * Last update time
     */
    private Date updateTime;

}
