package com.xaplanterisnikos.guitarshop.mappers;


import com.xaplanterisnikos.guitarshop.dto.SignUpDTO;
import com.xaplanterisnikos.guitarshop.dto.UserDTO;
import com.xaplanterisnikos.guitarshop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for mapping between User entities and DTOs.
 * This interface defines methods for converting User entities to UserDTOs and SignUpDTOs to User entities.
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user the User entity to be converted
     * @return the corresponding UserDTO
     */
    UserDTO toUserDto(User user);

    /**
     * Maps a SignUpDTO to a User entity, ignoring the 'password' field.
     *
     * @param signUpDto the SignUpDTO to be mapped
     * @return the corresponding User entity
     */
    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDTO signUpDto);




}
