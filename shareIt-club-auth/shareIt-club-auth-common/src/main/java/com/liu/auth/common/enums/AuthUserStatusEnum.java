package com.liu.auth.common.enums;

import lombok.Getter;

/**
 * User status enumeration
 *
 * @author Liu Tongxun
 * @date 2025/08/25
 */
@Getter
public enum AuthUserStatusEnum {

    OPEN(0, "Enabled"),   // User is enabled
    CLOSE(1, "Disabled"); // User is disabled

    public int code;   // Code representing the user status
    public String desc; // Description of the user status

    // Constructor to initialize the enum with code and description
    AuthUserStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Get the enum instance by its code.
     *
     * @param codeVal the code to search for
     * @return the corresponding enum instance, or null if not found
     */
    public static AuthUserStatusEnum getByCode(int codeVal) {
        for (AuthUserStatusEnum resultCodeEnum : AuthUserStatusEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;  // Return the matching enum
            }
        }
        return null;  // Return null if no match is found
    }

}
