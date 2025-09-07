package com.liu.auth.application.convert;

import com.liu.auth.application.dto.AuthRoleDTO;
import com.liu.auth.domain.entity.AuthRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Role DTO to BO Converter
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
@Mapper
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);

}
