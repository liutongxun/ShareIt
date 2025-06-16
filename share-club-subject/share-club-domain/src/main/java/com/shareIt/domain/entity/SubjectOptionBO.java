package com.shareIt.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Question DTO (Data Transfer Object)
 * Represents the options and correct answer for a subject/question.
 *
 * @author Liu Tongxun
 * @since 2025/06/14
 */
@Data
public class SubjectOptionBO implements Serializable {

    /**
     * The correct answer to the question
     */
    private String subjectAnswer;

    /**
     * List of answer options for the question
     */
    private List<SubjectAnswerBO> optionList;

}
