package com.shareIt.subject.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Subject Information Table (SubjectInfo) Entity Class
 *
 * Represents the basic information for a question in the system.
 * Includes fields such as question title, difficulty, type, score, analysis,
 * as well as audit fields and logical deletion flag.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
@Data
public class SubjectInfo implements Serializable {
    private static final long serialVersionUID = -71318372165220898L;

    /**
     * Primary Key
     */
    private Long id;

    /**
     * Question Title
     */
    private String subjectName;

    /**
     * Question Difficulty
     */
    private Integer subjectDifficulty;

    /**
     * Author (Person who created the question)
     */
    private String authorName;

    /**
     * Question Type (1 = Single-Choice, 2 = Multiple-Choice, 3 = True/False, 4 = Essay)
     */
    private Integer subjectType;

    /**
     * Question Score
     */
    private Integer subjectScore;

    /**
     * Question Analysis (Explanation)
     */
    private String subjectAnalysis;

    /**
     * Created By (User who created the record)
     */
    private String createdBy;

    /**
     * Creation Timestamp
     */
    private Date createdTime;

    /**
     * Updated By (User who last modified the record)
     */
    private String updatedBy;

    /**
     * Update Timestamp
     */
    private Date updatedTime;

    /**
     * Logical Deletion Flag (0 = Not Deleted, 1 = Deleted)
     */
    private Integer isDeleted;

    /**
     * Number of Times the Question Has Been Attempted
     */
    private Integer subjectCount;
}
