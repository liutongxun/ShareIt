package com.liu.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.google.gson.Gson;
import com.liu.auth.common.enums.AuthUserStatusEnum;
import com.liu.auth.common.enums.IsDeletedFlagEnum;
import com.liu.auth.domain.constants.AuthConstant;
import com.liu.auth.domain.convert.AuthUserBOConverter;
import com.liu.auth.domain.entity.AuthUserBO;
import com.liu.auth.domain.redis.RedisUtil;
import com.liu.auth.domain.service.AuthUserDomainService;
import com.liu.auth.infra.basic.entity.*;
import com.liu.auth.infra.basic.service.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;



    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthUserRoleService authUserRoleService;


    private String salt = "shareIt";

    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBO authUserBO) {

        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authUserService.insert(authUser);

        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.queryByCondition(authRole);
        Long roleId = roleResult.getId();
        Long userId = authUser.getId();
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(userId);
        authUserRole.setRoleId(roleId);
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.insert(authUserRole);


        return count > 0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);


        Integer count = authUserService.updateByUserName(authUser);
        return count > 0;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        // Create a new AuthUser entity and set the ID and deletion flag
        AuthUser authUser = new AuthUser();
        authUser.setId(authUserBO.getId());  // Set user ID
        authUser.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());  // Mark as deleted

        // Update the user status in the database
        Integer count = authUserService.update(authUser);

        // Synchronize the cache with the update, ensuring any changes are reflected
        return count > 0;  // Return true if the update was successful (count > 0)
    }




}
