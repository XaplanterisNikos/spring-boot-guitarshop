package com.xaplanterisnikos.guitarshop.mappers;


import com.xaplanterisnikos.guitarshop.dto.SignUpDTO;
import com.xaplanterisnikos.guitarshop.dto.UserDTO;
import com.xaplanterisnikos.guitarshop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDTO toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDTO signUpDto);




}
