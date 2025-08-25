package com.liu.auth.infra.basic.service.impl;

import com.liu.auth.infra.basic.entity.AuthUser;
import com.liu.auth.infra.basic.mapper.AuthUserDao;
import com.liu.auth.infra.basic.service.AuthUserService;
import com.liu.auth.infra.basic.service.AuthUserService2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service implementation for handling AuthUser operations.
 *
 * <p>This class provides the concrete implementation of the AuthUserService
 * interface, delegating CRUD and query methods to the underlying AuthUserDao.</p>
 *
 * @author Liu tongxun
 * @since 2025/08/25
 */
@Service("authUserService")
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserDao authUserDao;

    /**
     * Retrieve a single AuthUser by its primary key.
     *
     * @param id the primary key of the user
     * @return the AuthUser instance, or null if not found
     */
    @Override
    public AuthUser queryById(Long id) {
        return this.authUserDao.queryById(id);
    }

    /**
     * Insert a new AuthUser record.
     *
     * @param authUser the AuthUser instance to insert
     * @return the number of rows affected (typically 1 if successful)
     */
    @Override
    public Integer insert(AuthUser authUser) {
        return this.authUserDao.insert(authUser);
    }

    /**
     * Update an existing AuthUser record.
     *
     * @param authUser the AuthUser instance containing updated data
     * @return the number of rows affected (typically 1 if successful)
     */
    @Override
    public Integer update(AuthUser authUser) {
        return this.authUserDao.update(authUser);
    }

    /**
     * Delete a single AuthUser by its primary key.
     *
     * @param id the primary key of the user to delete
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserDao.deleteById(id) > 0;
    }

    /**
     * Query AuthUser records matching the given example criteria,
     * with optional pagination limits.
     *
     * @param authUser an example AuthUser containing filter criteria
     * @return a list of matching AuthUser instances
     */
    @Override
    public List<AuthUser> queryByCondition(AuthUser authUser) {
        return this.authUserDao.queryAllByLimit(authUser);
    }

    /**
     * Update an AuthUser record identified by its username.
     *
     * @param authUser the AuthUser instance containing the username and new data
     * @return the number of rows affected
     */
    @Override
    public Integer updateByUserName(AuthUser authUser) {
        return this.authUserDao.updateByUserName(authUser);
    }

    /**
     * Retrieve a list of AuthUser records by their usernames.
     *
     * @param userNameList a list of usernames to query
     * @return a list of matching AuthUser instances
     */
    @Override
    public List<AuthUser> listUserInfoByIds(List<String> userNameList) {
        return authUserDao.listUserInfoByIds(userNameList);
    }
}
