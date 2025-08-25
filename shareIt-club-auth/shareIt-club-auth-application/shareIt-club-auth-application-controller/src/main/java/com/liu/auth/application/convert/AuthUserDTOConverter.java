package com.liu.auth.application.convert;

import com.liu.auth.entity.AuthUserDTO;
import com.liu.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * User DTO Converter
 *
 * @author Liu Tongxun
 * @since 2025/08/25
 */
@Mapper
public interface AuthUserDTOConverter {

    // Instance of the converter
    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);

    /**
     * Convert AuthUserDTO to AuthUserBO.
     *
     * @param authUserDTO the AuthUserDTO to convert
     * @return the converted AuthUserBO
     */
    AuthUserBO convertDTOToBO(AuthUserDTO authUserDTO);

    /**
     * Convert AuthUserBO to AuthUserDTO.
     *
     * @param authUserBO the AuthUserBO to convert
     * @return the converted AuthUserDTO
     */
    AuthUserDTO convertBOToDTO(AuthUserBO authUserBO);

    /**
     * Convert a list of AuthUserBO to a list of AuthUserDTO.
     *
     * @param authUserBO the list of AuthUserBO to convert
     * @return the list of converted AuthUserDTO
     */
    List<AuthUserDTO> convertBOToDTO(List<AuthUserBO> authUserBO);

}
