package com.shareIt.domain.hander.subject;


import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.subject.common.enums.SubjectInfoTypeEnum;
/**
 * Strategy interface for handling different types of questions.
 * Each implementation corresponds to a specific question type (e.g., single choice, multiple choice, etc.)
 * and defines how to process or insert such questions.
 *
 * Author: Liu Tongxun
 * Date: 2025/06/03
 */
public interface SubjectTypeHandler {

    /**
     * Returns the enum value representing the type of question this handler supports.
     *
     * @return the corresponding SubjectInfoTypeEnum
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * Executes the logic for inserting a question of the supported type.
     *
     * @param subjectInfoBO the business object representing the question to be inserted
     */
    void add(SubjectInfoBO subjectInfoBO);


}