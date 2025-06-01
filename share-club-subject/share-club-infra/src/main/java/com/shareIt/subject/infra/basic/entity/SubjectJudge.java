package com.shareIt.subject.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * True/False Question (SubjectJudge) Entity Class
 *
 * Represents a true/false question's basic data, including whether the answer is correct
 * and audit fields.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
@Data
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = 725783721496341698L;

    /**
     * Primary key
     */
    private Long id;

    /**
     * Associated question ID (foreign key to SubjectInfo)
     */
    private Long subjectId;

    /**
     * Indicates whether the answer is correct (1 = correct, 0 = incorrect)
     */
    private Integer isCorrect;

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
