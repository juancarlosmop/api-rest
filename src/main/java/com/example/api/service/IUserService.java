package com.example.api.service;

import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public interface IUserService {
    public GeneralResponseDTO getAllUsers();
    public GeneralResponseDTO getUserById(Long id);
    public GeneralResponseDTO createUser(UserDTO user);
    public GeneralResponseDTO updateUserById(Long id, UserDTO usuarioDTO);
    public GeneralResponseDTO deleteUserById(Long id);

}
