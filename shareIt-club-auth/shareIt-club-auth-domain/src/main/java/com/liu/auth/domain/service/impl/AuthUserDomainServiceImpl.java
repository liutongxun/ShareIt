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



    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBO authUserBO) {

        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);

        Integer count = authUserService.insert(authUser);

        return count > 0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);

        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

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
