package com.shareIt.subject.common.enums;

import lombok.Getter;
/**
 * Enumeration of Question Types.
 * 1 - Single Choice, 2 - Multiple Choice, 3 - True/False, 4 - Short Answer
 *
 * @author: Liu Tongxun
 * @date: 2025/06/0 3
 */
@Getter
public enum SubjectInfoTypeEnum {

    RADIO(1, "Single Choice"),
    MULTIPLE(2, "Multiple Choice"),
    JUDGE(3, "True/False"),
    BRIEF(4, "Short Answer");

    // Numerical code representing the question type
    public int code;

    // Description of the question type
    public String desc;

    /**
     * Constructor for the enum.
     *
     * @param code the integer code of the question type
     * @param desc the description of the question type
     */
    SubjectInfoTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    /**
     * Retrieve the enum constant based on its code value.
     *
     * @param codeVal the code to match
     * @return the corresponding SubjectInfoTypeEnum, or null if no match is found
     */
    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for(SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
