package com.liu.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * Entity class representing an authenticated user.
 *
 * <p>This class corresponds to the "AuthUser" table and encapsulates
 * the core user profile and credential information used by the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/07/29
 */
@Data
public class AuthUser implements Serializable {
    private static final long serialVersionUID = -50435275569670090L;

    /** Unique identifier for the user */
    private Long id;

    /** Username for login/authentication */
    private String userName;

    /** Display name or nickname of the user */
    private String nickName;

    /** Email address of the user */
    private String email;

    /** Phone number of the user */
    private String phone;

    /** Hashed password for authentication */
    private String password;

    /** Gender of the user (e.g., 0 = unspecified, 1 = male, 2 = female) */
    private Integer sex;

    /** URL or path to the user's avatar image */
    private String avatar;

    /** Account status (e.g., 0 = inactive, 1 = active) */
    private Integer status;

    /** Brief personal introduction or bio */
    private String introduce;

    /** Additional JSON-formatted metadata */
    private String extJson;

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
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Integer getSex() {
//        return sex;
//    }
//
//    public void setSex(Integer sex) {
//        this.sex = sex;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public String getIntroduce() {
//        return introduce;
//    }
//
//    public void setIntroduce(String introduce) {
//        this.introduce = introduce;
//    }
//
//    public String getExtJson() {
//        return extJson;
//    }
//
//    public void setExtJson(String extJson) {
//        this.extJson = extJson;
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

