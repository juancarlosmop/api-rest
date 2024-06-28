package com.example.api.mapper;

import com.example.api.model.dto.UserDTO;
import com.example.api.model.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO userEntityToDto(UserEntity userEntity){
        return UserDTO
                .builder()
                .name(userEntity.getName())
                .lastName(userEntity.getLastName())
                .age(userEntity.getAge())
                .email(userEntity.getEmail())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .build();

    }

    public static List<UserDTO> userEntityListToDtoList(List<UserEntity> listUserEntity){
        return listUserEntity
                .stream()
                .map( user -> UserDTO.builder()
                        .name(user.getName())
                        .lastName(user.getLastName())
                        .age(user.getAge())
                        .email(user.getEmail())
                        .userName(user.getUserName())
                        .password(user.getPassword())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public static UserEntity userDtoToUserEntity(UserDTO userDTO){
        return UserEntity
                .builder()
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .age(userDTO.getAge())
                .email(userDTO.getEmail())
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .build();
    }
}
