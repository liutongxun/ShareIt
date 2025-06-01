package com.shareIt.subject.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Single-Choice Question (SubjectRadio) Entity Class
 *
 * Represents a single-choice question’s option data, including the option type (A, B, C, D),
 * content text, correctness indicator, and audit fields.
 *
 * Author: Liu Tongxun
 * Since: 2025/06/01
 */
@Data
public class SubjectRadio implements Serializable {
    private static final long serialVersionUID = 528349687787614869L;

    /**
     * Primary key
     */
    private Long id;

    /**
     * Associated question ID (foreign key to SubjectInfo)
     */
    private Long subjectId;

    /**
     * Option type (e.g., 1 = A, 2 = B, 3 = C, 4 = D)
     */
    private Integer optionType;

    /**
     * Option content text
     */
    private String optionContent;

    /**
     * Indicates whether this option is correct (1 = correct, 0 = incorrect)
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
