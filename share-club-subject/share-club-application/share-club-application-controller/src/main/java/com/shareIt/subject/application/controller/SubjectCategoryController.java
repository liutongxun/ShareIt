package com.shareIt.subject.application.controller;



import com.shareIt.subject.infra.basic.entity.SubjectCategory;
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
import java.util.List;

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

    /**
     * Query Question Categories
     */
    @Operation(
            summary     = "Query primary categories",
            description = "Returns a list of all top-level subject categories"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description  = "Request successful",
                    content      = @Content(
                            mediaType = "application/json",
                            schema    = @Schema(type = "array", implementation = SubjectCategoryDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "Query failed")
    })
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory() {
        try {
            List<SubjectCategoryBO>  subjectCategoryBOList = subjectCategoryDomainService.queryPrimaryCategory();

            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
                    convertBoListToDtoList(subjectCategoryBOList);

            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("Query failed");
        }

    }

    /**
     * Query secondary categories by category ID
     */
    @Operation(
            summary     = "Query secondary categories by primary category ID",
            description = "Retrieves a list of secondary SubjectCategoryDTOs based on the given primary category ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description  = "Query successful",
                    content      = @Content(schema = @Schema(implementation = Result.class))
            ),
            @ApiResponse(responseCode = "400", description = "Primary category ID cannot be null or invalid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO
                                                                                    subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}"
                        , JSON.toJSONString(subjectCategoryDTO));
            }
            System.out.printf("subjectCategoryDTO.getId() subjectCategoryDTO.getId() subjectCategoryDTO.getId() "+subjectCategoryDTO.getId() );
            Preconditions.checkNotNull(subjectCategoryDTO.getId() ,
                                            "Category ID cannot be null.");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);

            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
                    convertBoListToDtoList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("Query failed");
        }
    }

    /**
     * Update an existing category
     */
    @Operation(
            summary     = "Update an existing category",
            description = "Updates the details of a subject category based on the provided DTO"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description  = "Category updated successfully",
                    content      = @Content(schema = @Schema(implementation = Result.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input parameters or missing ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.error:{}", e.getMessage(), e);
            return Result.fail("Failed to update category.");
        }

    }

    /**
     * Delete a category
     */
    @Operation(
            summary     = "Delete a category",
            description = "Marks the specified subject category as deleted"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description  = "Category deleted successfully",
                    content      = @Content(schema = @Schema(implementation = Result.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input parameters or missing ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage(), e);
            return Result.fail("Category deletion failed");
        }

    }



}
