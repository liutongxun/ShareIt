package com.shareIt.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Subject Answer Business Object (BO)
 *
 * Represents an answer option in the business layer, including its type, content, and correctness.
 *
 * Author: Liu Tongxun
 * Date: 2025/06/01
 */
@Data
public class SubjectAnswerBO implements Serializable {

    /**
     * Identifier for the answer option (e.g., A, B, C)
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