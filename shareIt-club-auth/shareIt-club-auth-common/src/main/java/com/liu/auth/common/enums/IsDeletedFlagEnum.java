package com.liu.auth.common.enums;

import lombok.Getter;

/**
 * Deletion status enumeration
 *
 * @author Liu Tongxun
 * @date 2025/08/25
 */

@Getter
public enum IsDeletedFlagEnum {

    DELETED(1, "Deleted"),   // The item is deleted
    UN_DELETED(0, "Not Deleted");  // The item is not deleted

    public int code;    // Code representing the deletion status
    public String desc; // Description of the deletion status

    // Constructor to initialize the enum with code and description
    IsDeletedFlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Get the enum instance by its code.
     *
     * @param codeVal the code to search for
     * @return the corresponding enum instance, or null if not found
     */
    public static IsDeletedFlagEnum getByCode(int codeVal) {
        for (IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;  // Return the matching enum
            }
        }
        return null;  // Return null if no match is found
    }
}
