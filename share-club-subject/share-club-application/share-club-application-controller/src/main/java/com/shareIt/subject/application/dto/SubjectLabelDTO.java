package com.shareIt.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Subject Label DTO
 *
 * @author Liu Tongxun
 * @date 2025/5/24
 */
@Data
public class SubjectLabelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Primary key
     */
    private Long id;

    /**
     * Category ID
     */
    private Long categoryId;

    /**
     * Label name
     */
    private String labelName;

    /**
     * Sort number
     */
    private Integer sortNum;

}

