package com.shareIt.subject.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目分类
 *
 * @author: ChickenWing
 * @date: 2023/10/3
 */
@Data
@Schema(
        name        = "SubjectCategoryDTO",
        description = "Data Transfer Object for subject category details"
)
public class SubjectCategoryDTO implements Serializable {

    @Schema(
            description = "Unique identifier of the category (auto-generated)",
            example     = "1001"
    )
    private Long id;

    @Schema(
            description = "Name of the category",
            example     = "Mathematics",
            required    = true
    )
    private String categoryName;

    @Schema(
            description = "Type code of the category, e.g., 1=Science, 2=Arts",
            example     = "1",
            required    = true
    )
    private Integer categoryType;

    @Schema(
            description = "URL of the category icon image",
            example     = "https://example.com/images/math.png"
    )
    private String imageUrl;

    @Schema(
            description = "Identifier of the parent category; use 0 for root",
            example     = "0",
            required    = true
    )
    private Long parentId;

    @Schema(
            description = "Number of items or subcategories under this category",
            example     = "10"
    )
    private Integer count;

    @Schema(
            description = "List of associated subject labels",
            implementation = SubjectLabelDTO.class
    )
    private List<SubjectLabelDTO> labelDTOList;

}