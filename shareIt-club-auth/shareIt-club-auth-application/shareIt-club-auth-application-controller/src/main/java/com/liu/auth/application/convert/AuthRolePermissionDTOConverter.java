package com.liu.auth.application.convert;

import com.liu.auth.application.dto.AuthRolePermissionDTO;
import com.liu.auth.domain.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Permission DTO Converter
 *
 * @author Liu Tongxun
 * @since 2025/09/10
 */

@Mapper
public interface AuthRolePermissionDTOConverter {

    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO authRolePermissionDTO);

}
