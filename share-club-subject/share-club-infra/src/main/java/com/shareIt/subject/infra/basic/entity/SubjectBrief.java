package com.shareIt.subject.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * Essay Question (SubjectBrief) Entity Class
 *
 * Represents the answer details for an essay-type question.
 * Includes fields for primary key, associated question ID,
 * answer text, audit fields, and logical deletion flag.
 *
 * Author: Liu Tongxun
 * Since: 2025/06/01
 */
@Data
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = 904086937348284785L;

    /**
     * Primary key
     */
    private Long id;

    /**
     * Associated question ID (foreign key to SubjectInfo)
     */
    private Integer subjectId;

    /**
     * Essay answer text
     */
    private String subjectAnswer;

    /**
     * Created by (username or ID)
     */
    private String createdBy;

    /**
     * Creation timestamp
     */
    private Date createdTime;

    /**
     * Updated by (username or ID)
     */
    private String updateBy;

    /**
     * Update timestamp
     */
    private Date updateTime;

    /**
     * Logical deletion flag (0 = not deleted, 1 = deleted)
     */
    private Integer isDeleted;
}

