package com.liu.auth.application.convert;

import com.liu.auth.application.dto.AuthPermissionDTO;
import com.liu.auth.domain.entity.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Permission DTO Converter
 *
 * @author Liu tongxun
 * @since 2025/09/10
 */
@Mapper
public interface AuthPermissionDTOConverter {

    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convertDTOToBO(AuthPermissionDTO authPermissionDTO);

}
