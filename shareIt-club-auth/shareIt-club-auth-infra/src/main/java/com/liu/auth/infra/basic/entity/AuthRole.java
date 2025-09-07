package com.liu.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * Entity class representing a user role.
 *
 * <p>This class corresponds to the "AuthRole" table and encapsulates
 * the definition of roles within the authorization framework.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
@Data
public class AuthRole implements Serializable {
    private static final long serialVersionUID = 422256240999600735L;

    /** Unique identifier for this role record */
    private Long id;

    /** Descriptive name of the role (e.g., "Administrator", "User") */
    private String roleName;

    /** Unique key used in code to check role membership (e.g., "ROLE_ADMIN") */
    private String roleKey;

    /** Username of the user who created this record */
    private String createdBy;

    /** Timestamp when this record was first created */
    private Date createdTime;

    /** Username of the user who last updated this record */
    private String updateBy;

    /** Timestamp when this record was last updated */
    private Date updateTime;

    /** Logical deletion flag (e.g., 0 = not deleted, 1 = deleted) */
    private Integer isDeleted;



//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public String getRoleKey() {
//        return roleKey;
//    }
//
//    public void setRoleKey(String roleKey) {
//        this.roleKey = roleKey;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Date getCreatedTime() {
//        return createdTime;
//    }
//
//    public void setCreatedTime(Date createdTime) {
//        this.createdTime = createdTime;
//    }
//
//    public String getUpdateBy() {
//        return updateBy;
//    }
//
//    public void setUpdateBy(String updateBy) {
//        this.updateBy = updateBy;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public Integer getIsDeleted() {
//        return isDeleted;
//    }
//
//    public void setIsDeleted(Integer isDeleted) {
//        this.isDeleted = isDeleted;
//    }

}

