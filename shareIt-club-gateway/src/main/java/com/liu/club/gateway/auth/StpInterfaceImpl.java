package com.liu.club.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.club.gateway.entity.AuthPermission;
import com.liu.club.gateway.entity.AuthRole;
import com.liu.club.gateway.redis.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 *
 * @author: ChickenWing
 * @date: 2023/10/28
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";

    private String authRolePrefix = "auth.role";

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return getAuth(loginId.toString(), authPermissionPrefix);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return getAuth(loginId.toString(), authRolePrefix);
    }

    private List<String> getAuth(String loginId, String prefix) {
        String authKey = redisUtil.buildKey(prefix, loginId.toString());
        String authValue = redisUtil.get(authKey);
        if (StringUtils.isBlank(authValue)) {
            return Collections.emptyList();
        }
        List<String> authList = new LinkedList<>();
        if (authRolePrefix.equals(prefix)) {
            List<AuthRole> roleList = new Gson().fromJson(authValue, new TypeToken<List<AuthRole>>() {
            }.getType());
            authList = roleList.stream().map(AuthRole::getRoleKey).collect(Collectors.toList());
        } else if (authPermissionPrefix.equals(prefix)) {
            List<AuthPermission> permissionList = new Gson().fromJson(authValue, new TypeToken<List<AuthPermission>>() {
            }.getType());
            authList = permissionList.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());
        }
        return authList;
    }

}
