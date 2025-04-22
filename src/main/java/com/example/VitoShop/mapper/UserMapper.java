package com.example.VitoShop.mapper;

import com.example.VitoShop.DTO.UserDTO;
import com.example.VitoShop.entity.UsersEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userEntityToUserDTO(UsersEntity usersEntity);
    UsersEntity userDTOToUserEntity(UserDTO userDTO);
}
