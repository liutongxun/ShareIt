package com.shareIt.subject.common.enums;

import lombok.Getter;

/**
 * Deletion Status Enum
 * 
 * @author: Liu Tongxun
 * @date: 2025/05/30
 */
@Getter
public enum IsDeletedFlagEnum {

    DELETED(1,"Deleted"),
    UN_DELETED(0,"Not deleted");

    public int code;

    public String desc;

    IsDeletedFlagEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedFlagEnum getByCode(int codeVal){
        for(IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
