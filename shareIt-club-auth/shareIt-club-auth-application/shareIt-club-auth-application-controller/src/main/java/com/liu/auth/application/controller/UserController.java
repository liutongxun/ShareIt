package com.liu.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.liu.auth.application.convert.AuthUserDTOConverter;
import com.liu.auth.domain.entity.AuthUserBO;
import com.liu.auth.domain.service.AuthUserDomainService;
import com.liu.auth.domain.service.AuthUserDomainService2;
import com.liu.auth.entity.AuthUserDTO;
import com.liu.auth.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liu tongxun
 * @date 2025/08/25
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Resource
    private AuthUserDomainService authUserDomainService;

    /**
     * User registration
     */
    @RequestMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDTO authUserDTO) {
        try {
            // Log the user registration data if info-level logging is enabled
            if (log.isInfoEnabled()) {
                log.info("UserController.register.dto:{}", JSON.toJSONString(authUserDTO));
            }

            // Check if the user information is valid
            checkUserInfo(authUserDTO);

            // Convert AuthUserDTO to AuthUserBO
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);

            // Register the user and return the result
            return Result.ok(authUserDomainService.register(authUserBO));
        } catch (Exception e) {
            // Log the error and return a failure result
            log.error("UserController.register.error:{}", e.getMessage(), e);
            return Result.fail("User registration failed");
        }
    }

    /**
     * Modify user information
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthUserDTO authUserDTO) {
        try {
            // Log the user update data if info-level logging is enabled
            if (log.isInfoEnabled()) {
                log.info("UserController.update.dto:{}", JSON.toJSONString(authUserDTO));
            }

            // Check if the user information is valid
            checkUserInfo(authUserDTO);

            // Convert AuthUserDTO to AuthUserBO
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);

            // Update the user information and return the result
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            // Log the error and return a failure result
            log.error("UserController.update.error:{}", e.getMessage(), e);
            return Result.fail("Failed to update user information");
        }
    }

    private void checkUserInfo(@RequestBody AuthUserDTO authUserDTO) {
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
    }

    /**
     * Delete user
     *
     * This method handles the deletion of a user based on the provided user data.
     * It converts the incoming DTO (Data Transfer Object) to a Business Object (BO)
     * and calls the domain service to perform the deletion.
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthUserDTO authUserDTO) {
        try {
            // Log the incoming DTO if info-level logging is enabled
            if (log.isInfoEnabled()) {
                log.info("UserController.delete.dto:{}", JSON.toJSONString(authUserDTO));
            }

            // Convert the DTO to a Business Object (BO)
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);

            // Call the domain service to update the user, which could include deleting logic
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            // Log any errors encountered during the process
            log.error("UserController.delete.error:{}", e.getMessage(), e);

            // Return a failure result if deletion fails
            return Result.fail("Failed to delete user information");
        }
    }



}
