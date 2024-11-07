package com.youness.portfolioApp.mapper;

import com.youness.portfolioApp.dto.UserDTO;
import com.youness.portfolioApp.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    //    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toUserDTO(User user);

    User toUserEntity(UserDTO dto);

}
