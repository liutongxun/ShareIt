package com.shareIt.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Subject Answer DTO
 *
 * Represents an answer option for a question, including its type, content, and correctness.
 *
 * @author Liu Tongxun
 * @date 2025/06/01
 */
@Data
public class SubjectAnswerDTO implements Serializable {

    /**
     * Answer option identifier (e.g., A, B, C)
     */
    private Integer optionType;

    /**
     * Answer content
     */
    private String optionContent;

    /**
     * Whether the answer is correct (1 for true, 0 for false)
     */
    private Integer isCorrect;
}

