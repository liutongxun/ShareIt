package com.shareIt.domain.entity;

import com.shareIt.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Subject Information Business Object (BO)
 *
 * Represents the business layer data structure for a subject, including pagination info,
 * basic subject details, categories, tags, answer options, etc.
 *
 * Author: Liu Tongxun
 * Date: 2025/06/01
 */
@Data
public class SubjectInfoBO extends PageInfo implements Serializable {

    /**
     * Primary key
     */
    private Long id;

    /**
     * Subject name
     */
    private String subjectName;

    /**
     * Subject difficulty
     */
    private Integer subjectDifficult;

    /**
     * Author of the subject
     */
    private String settleName;

    /**
     * Subject type: 1 - Single Choice, 2 - Multiple Choice, 3 - True/False, 4 - Short Answer
     */
    private Integer subjectType;

    /**
     * Subject score
     */
    private Integer subjectScore;

    /**
     * Explanation of the subject
     */
    private String subjectParse;

    /**
     * Correct answer
     */
    private String subjectAnswer;

    /**
     * List of category IDs
     */
    private List<Integer> categoryIds;

    /**
     * List of label IDs
     */
    private List<Integer> labelIds;

    /**
     * List of label names
     */
    private List<String> labelName;

    /**
     * List of answer options
     */
    private List<SubjectAnswerBO> optionList;

    /**
     * Single category ID (optional)
     */
    private Long categoryId;

    /**
     * Single label ID (optional)
     */
    private Long labelId;

    /**
     * Keyword
     */
    private String keyWord;

    /**
     * Creator nickname
     */
    private String createUser;

    /**
     * Creator avatar
     */
    private String createUserAvatar;

    /**
     * Number of subjects
     */
    private Integer subjectCount;

    /**
     * Whether the current user has liked this subject
     */
    private Boolean liked;

    /**
     * Total number of likes for this subject
     */
    private Integer likedCount;

    /**
     * ID of the next subject
     */
    private Long nextSubjectId;

    /**
     * ID of the previous subject
     */
    private Long lastSubjectId;


}


