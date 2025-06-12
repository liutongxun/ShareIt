package com.shareIt.subject.application.dto;

import com.shareIt.subject.common.entity.PageInfo;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * Subject Data Transfer Object (DTO)
 *
 * Represents the structure of a subject/question with related metadata.
 *
 * @author Liu Tongxun
 * @date 2025/06/01
 */
@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {

    /**
     * Primary key
     */
    private Long id;

    /**
     * Subject title
     */
    private String subjectName;

    /**
     * Subject difficulty
     */
    private Integer subjectDifficult;

    /**
     * Author of the question
     */
    private String settleName;

    /**
     * Subject type: 1 - Single Choice, 2 - Multiple Choice, 3 - True/False, 4 - Short Answer
     */
    private Integer subjectType;

    /**
     * Score of the subject
     */
    private Integer subjectScore;

    /**
     * Explanation of the subject
     */
    private String subjectParse;

    /**
     * Correct answer to the subject
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
     * Single category ID (optional)
     */
    private Long categoryId;

    /**
     * Single label ID (optional)
     */
    private Long labelId;

    /**
     * Keyword associated with the subject
     */
    private String keyWord;

    /**
     * Nickname of the creator
     */
    private String createUser;

    /**
     * Avatar of the creator
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
     * Number of likes for this subject
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

    /**
     * Answer Option
     */
    private List<SubjectAnswerDTO> optionList;
}
