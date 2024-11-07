package com.youness.portfolioApp.services;

import com.youness.portfolioApp.dto.UserDTO;
import com.youness.portfolioApp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDTO> findUsers();

    UserDTO getUser(Long idUser);

    User addUser(User user);

    UserDTO updateUser(Long idUser, UserDTO userDTO);

    void deleteUser(Long idUser);

    String verify(User user);
}