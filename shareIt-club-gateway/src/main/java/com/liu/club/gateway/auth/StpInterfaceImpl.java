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
 * Custom Permission Validation Interface Extension
 *
 * @author: Liu Tongxun
 * @date: 2025/07/27
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";

    private String authRolePrefix = "auth.role";

    /**
     * Retrieve the list of permission keys for a given user.
     *
     * @param loginId   the user's unique identifier
     * @param loginType the type of login (unused in this implementation)
     * @return a list of permission key strings, or an empty list if none are found
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return getAuth(loginId.toString(), authPermissionPrefix);
    }

    /**
     * Retrieve the list of role keys for a given user.
     *
     * @param loginId   the user's unique identifier
     * @param loginType the type of login (unused in this implementation)
     * @return a list of role key strings, or an empty list if none are found
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return getAuth(loginId.toString(), authRolePrefix);
    }


    /**
     * Internal helper to fetch and parse JSON-encoded authorization data from Redis.
     *
     * @param loginId the user's unique identifier as a string
     * @param prefix  the Redis key prefix (either role or permission)
     * @return a list of extracted keys (roleKey or permissionKey), or an empty list if no data exists
     */
    private List<String> getAuth(String loginId, String prefix) {
        // Construct the Redis key (e.g., "auth.permission.1234" or "auth.role.1234")
        String authKey = redisUtil.buildKey(prefix, loginId);
        // Fetch the JSON string from Redis
        String authValue = redisUtil.get(authKey);
        if (StringUtils.isBlank(authValue)) {
            // Return empty list if no data is found
            return Collections.emptyList();
        }

        List<String> authList = new LinkedList<>();
        Gson gson = new Gson();

        if (authRolePrefix.equals(prefix)) {
            // Deserialize JSON into a list of AuthRole objects
            List<AuthRole> roleList = gson.fromJson(authValue, new TypeToken<List<AuthRole>>() {}.getType());
            // Extract the roleKey property from each AuthRole
            authList = roleList.stream()
                    .map(AuthRole::getRoleKey)
                    .collect(Collectors.toList());
        } else if (authPermissionPrefix.equals(prefix)) {
            // Deserialize JSON into a list of AuthPermission objects
            List<AuthPermission> permissionList = gson.fromJson(authValue, new TypeToken<List<AuthPermission>>() {}.getType());
            // Extract the permissionKey property from each AuthPermission
            authList = permissionList.stream()
                    .map(AuthPermission::getPermissionKey)
                    .collect(Collectors.toList());
        }

        return authList;
    }

}
