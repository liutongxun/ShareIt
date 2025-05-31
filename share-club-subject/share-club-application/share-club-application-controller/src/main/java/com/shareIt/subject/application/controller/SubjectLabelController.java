package com.shareIt.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;

import com.shareIt.domain.entity.SubjectLabelBO;
import com.shareIt.domain.service.SubjectLabelDomainService;
import com.shareIt.subject.application.convert.SubjectLabelDTOConverter;
import com.shareIt.subject.application.dto.SubjectLabelDTO;
import com.shareIt.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * REST controller for managing SubjectLabel entities.
 *
 * Provides endpoints to create, read, update, delete, and query labels.
 *
 * @author: Liu Tongxun
 * @date: 2025-05-30
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {


    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;


    /**
     * Create new label
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()),
                    "Label name cannot be empty");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.add.error:{}", e.getMessage(), e);
            return Result.fail("Failed to add new label");
        }
    }


}
