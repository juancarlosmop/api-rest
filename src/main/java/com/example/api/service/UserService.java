package com.example.api.service;

import com.example.api.constants.StatusCodeEnum;
import com.example.api.mapper.UserMapper;
import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.dto.UserDTO;
import com.example.api.model.entity.UserEntity;
import com.example.api.dao.repository.UserRepository;
import com.example.api.util.FormatterUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public GeneralResponseDTO getAllUsers() {
        List<UserEntity>  listUser= userRepository.findAll();
        if(listUser!=null && listUser.isEmpty()){
            return GeneralResponseDTO
                    .builder()
                    .data( UserMapper.userEntityListToDtoList(listUser) )
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_001.getDescription())
                    .message("DATA SUCCESS")
                    .build();
        }else{
            return GeneralResponseDTO
                    .builder()
                    .data(Collections.emptyList())
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_002.getDescription())
                    .message("NOT DATA ")
                    .build();
        }
    }

    public GeneralResponseDTO getUserById(Long id) {
       Optional<UserEntity> user= userRepository.findById(id);
       if(user.isPresent()){
           return GeneralResponseDTO
                   .builder()
                   .data( UserMapper.userEntityToDto(user.get()) )
                   .dateTime(FormatterUtility.getDatetime())
                   .code(StatusCodeEnum.R_001.getDescription())
                   .message("DATA SUCCESS")
                   .build();

       }else{
           return GeneralResponseDTO
                   .builder()
                   .data(null)
                   .dateTime(FormatterUtility.getDatetime())
                   .code(StatusCodeEnum.R_002.getDescription())
                   .message("NOT DATA ")
                   .build();

       }

    }

    public GeneralResponseDTO createUser(UserDTO userDto) {
       Optional<UserEntity> user= userRepository.findByUserName(userDto.getUserName());
        if(!user.isPresent()) {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            return GeneralResponseDTO
                    .builder()
                    .data(userRepository.save(UserMapper.userDtoToUserEntity(userDto)))
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_001.getDescription())
                    .message("USER WAS CREATED SUCCESSFULLY")
                    .build();
        }else{
            return GeneralResponseDTO
                    .builder()
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_004.getDescription())
                    .message("USER WAS NOT CREATED")
                    .build();
        }
    }

    public GeneralResponseDTO updateUserById(Long id, UserDTO userDto) {
        Optional<UserEntity> user= userRepository.findByUserName(userDto.getUserName());
        if(user.isPresent()){
            UserEntity userEntity = UserMapper.userDtoToUserEntity(userDto);
            userEntity.setId(user.get().getId());
            return GeneralResponseDTO
                    .builder()
                    .data( UserMapper.userEntityToDto(userEntity) )
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_001.getDescription())
                    .message("DATA SUCCESS")
                    .build();

        }else{
            return GeneralResponseDTO
                    .builder()
                    .data(null)
                    .dateTime(FormatterUtility.getDatetime())
                    .code(StatusCodeEnum.R_002.getDescription())
                    .message("NOT DATA ")
                    .build();

        }
    }

    public GeneralResponseDTO deleteUserById(Long id) {
        userRepository.deleteById(id);
        return GeneralResponseDTO
                .builder()
                .data(null)
                .dateTime(FormatterUtility.getDatetime())
                .code(StatusCodeEnum.R_001.getDescription())
                .message("THE USER WAS DELETED ")
                .build();
    }

}
