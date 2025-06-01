package com.shareIt.subject.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * Multiple-Choice Question (SubjectMultiple) Entity Class
 *
 * Represents a multiple-choice question’s option data, including the option type,
 * content, correctness indicator, and audit fields.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
@Data
public class SubjectMultiple implements Serializable {
    private static final long serialVersionUID = 575755837160743772L;

    /**
     * Primary key
     */
    private Long id;

    /**
     * Associated question ID (foreign key to SubjectInfo)
     */
    private Long subjectId;

    /**
     * Option type (e.g., A=1, B=2, C=3, etc.)
     */
    private Long optionType;

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
