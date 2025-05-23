package com.shareIt.subject.application.controller;



import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.domain.service.SubjectCategoryDomainService;
import com.shareIt.subject.application.convert.SubjectCategoryDTOConverter;
import com.shareIt.subject.application.dto.SubjectCategoryDTO;
import com.shareIt.subject.common.entity.Result;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * controller for classification of practice questions
 *
 * @author: Liu Tongxun
 * @date: 2025/05/22
 */

@Tag(
        name        = "Category Management",
        description = "APIs for creating, querying and updating subject categories"
)
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;


    /**
     * create new category
     */
    @Operation(
            summary     = "Create a new category",
            description = "Creates a new subject category based on the provided DTO"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description  = "Category created successfully",
                    content      = @Content(schema = @Schema(implementation = Result.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}",
                                                    JSON.toJSONString(subjectCategoryDTO));
            }
            System.out.println(" subjectCategoryDTO.getCategoryType(),"+ subjectCategoryDTO.getCategoryType());
            Preconditions.checkNotNull(
                    subjectCategoryDTO.getCategoryType(),
                    "Category type must not be null"
            );
            Preconditions.checkArgument(
                    !StringUtils.isBlank(subjectCategoryDTO.getCategoryName()),
                    "Category name must not be blank"
            );
            Preconditions.checkNotNull(
                    subjectCategoryDTO.getParentId(),
                    "Parent category ID must not be null"
            );
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.
                                                    INSTANCE.
                                                    convertDtoToCategoryBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        }catch (Exception e){
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }

    }

}
