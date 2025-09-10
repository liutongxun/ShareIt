package com.liu.auth.domain.convert;

import com.liu.auth.domain.entity.AuthPermissionBO;
import com.liu.auth.infra.basic.entity.AuthPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Permission BO Converter
 *
 * @author Liu tongxun
 * @since 2025/09/10
 */
@Mapper
public interface AuthPermissionBOConverter {

    AuthPermissionBOConverter INSTANCE = Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO);

}
