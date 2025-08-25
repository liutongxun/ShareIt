package com.liu.auth.domain.convert;

import com.liu.auth.domain.entity.AuthUserBO;
import com.liu.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * User BO (Business Object) Converter
 *
 * @author Liu Tongxun
 * @date 2025/08/025
 */
@Mapper
public interface AuthUserBOConverter {

    AuthUserBOConverter INSTANCE = Mappers.getMapper(AuthUserBOConverter.class);

    AuthUser convertBOToEntity(AuthUserBO authUserBO);

    AuthUserBO convertEntityToBO(AuthUser authUser);

    List<AuthUserBO> convertEntityToBO(List<AuthUser> authUserList);

}
