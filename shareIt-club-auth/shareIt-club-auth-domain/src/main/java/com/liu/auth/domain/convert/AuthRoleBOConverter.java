package com.liu.auth.domain.convert;

import com.liu.auth.domain.entity.AuthRoleBO;
import com.liu.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Role BO (Business Object) Converter
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);

}
