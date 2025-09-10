package com.liu.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.liu.auth.entity.Result;
import com.liu.auth.application.convert.AuthPermissionDTOConverter;
import com.liu.auth.application.dto.AuthPermissionDTO;
import com.liu.auth.domain.entity.AuthPermissionBO;
import com.liu.auth.domain.service.AuthPermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 权限controller
 *
 * @author Liu tongxun
 * @since 2025/07/29
 */
@RestController
@RequestMapping("/permission/")
@Slf4j
public class PermissionController {

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

    /**
     * Add Permission
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.add.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(authPermissionDTO.getName()), "Permission name cannot be empty");
            Preconditions.checkNotNull(authPermissionDTO.getParentId(), "Permission parent ID cannot be null");

            // Convert DTO to BO
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);

            // Add the permission through domain service
            return Result.ok(authPermissionDomainService.add(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.add.error:{}", e.getMessage(), e);
            return Result.fail("Failed to add permission");
        }
    }


    /**
     * Update Permission
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.update.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getId(), "Permission ID cannot be null");

            // Convert DTO to BO
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);

            // Update the permission through domain service
            return Result.ok(authPermissionDomainService.update(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.update.error:{}", e.getMessage(), e);
            return Result.fail("Failed to update permission information");
        }
    }


    /**
     * Delete Permission
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.delete.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getId(), "Permission ID cannot be null");

            // Convert DTO to BO
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);

            // Delete the permission through domain service
            return Result.ok(authPermissionDomainService.delete(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.delete.error:{}", e.getMessage(), e);
            return Result.fail("Failed to delete permission information");
        }
    }

    /**
     * Get User Permissions
     */
    @RequestMapping("getPermission")
    public Result<Boolean> getPermission(String userName) {
        try {
            log.info("PermissionController.getPermission.userName:{}", userName);
            Preconditions.checkArgument(!StringUtils.isBlank(userName), "User ID cannot be empty");

            // Retrieve permissions for the given user
            return Result.ok(authPermissionDomainService.getPermission(userName));
        } catch (Exception e) {
            log.error("PermissionController.getPermission.error:{}", e.getMessage(), e);
            return Result.fail("Failed to query user permission information");
        }
    }


}
