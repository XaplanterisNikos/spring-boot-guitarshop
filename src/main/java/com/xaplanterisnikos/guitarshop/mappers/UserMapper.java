package com.xaplanterisnikos.guitarshop.mappers;


import com.xaplanterisnikos.guitarshop.dto.UserDto;
import com.xaplanterisnikos.guitarshop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

//    @Mapping(target = "password", ignore = true)
//    User signUpToUser(SignUpDto signUpDto);

}
