package com.shareIt.subject.common.enums;

import lombok.Getter;

/**
 * Category Type Enum
 *
 * Defines the level of a category: primary (top‑level) or secondary (sub‑category).
 * 
 * @author: Liu Tongxun
 * @date: 2025/05/30
 */
@Getter
public enum CategoryTypeEnum {

    PRIMARY(1, "Primary Category"),
    SECOND(2, "Secondary Category");

    public int code;

    public String desc;

    CategoryTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getByCode(int codeVal){
        for(CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
