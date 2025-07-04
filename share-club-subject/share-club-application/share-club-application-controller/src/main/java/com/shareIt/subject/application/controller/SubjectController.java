package com.shareIt.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.shareIt.domain.entity.SubjectAnswerBO;
import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.domain.service.SubjectInfoDomainService;
import com.shareIt.subject.application.convert.SubjectAnswerDTOConverter;
import com.shareIt.subject.application.convert.SubjectInfoDTOConverter;
import com.shareIt.subject.application.dto.SubjectInfoDTO;
import com.shareIt.subject.common.entity.PageResult;
import com.shareIt.subject.common.entity.Result;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/subject/subject")
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    /**
     * Add a new subject/question
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            // Validate that the subject name is not blank
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "Subject name cannot be empty");
            // Validate that subject difficulty is not null
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),
                                "Subject difficulty cannot be null");
            // Validate that subject type is not null
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),
                                "Subject type cannot be null");
            // Validate that subject score is not null
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),
                                       "Subject score cannot be null");
            // Validate that category ID list is not empty
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),
                    "Category ID cannot be empty");
            // Validate that label ID list is not empty
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),
                    "Label ID cannot be empty");

            // Convert DTO to BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.
                        convertDTOToBO(subjectInfoDTO);

            List<SubjectAnswerBO> subjectAnswerBOS =
                    SubjectAnswerDTOConverter.INSTANCE.convertListDTOToBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
//
            // Call domain service to add the subject
            subjectInfoDomainService.add(subjectInfoBO);

            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("Failed to add subject");
        }
    }

    /**
     * Query subject list with pagination
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "Category ID cannot be null");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "Label ID cannot be null");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            subjectInfoBO.setPageNo(subjectInfoDTO.getPageNo());
            subjectInfoBO.setPageSize(subjectInfoDTO.getPageSize());
            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("Failed to retrieve subject list with pagination");
        }
    }


    /**
     * Queries subject information based on the provided subject ID.
     *
     * @param subjectInfoDTO The Data Transfer Object (DTO) containing subject query parameters
     * @return A Result containing the SubjectInfoDTO with the subject details, or an error message if the query fails
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "Subject ID cannot be null");
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "Category ID cannot be null");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "Label ID cannot be null");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);

            System.out.printf(subjectInfoBO.toString());

            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);

            SubjectInfoDTO dto = SubjectInfoDTOConverter.INSTANCE.convertBOToDTO(boResult);

            return Result.ok(dto);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("Failed to query subject details");
        }
    }




}
