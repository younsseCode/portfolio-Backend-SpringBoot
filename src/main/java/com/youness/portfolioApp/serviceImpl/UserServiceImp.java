package com.youness.portfolioApp.serviceImpl;

import com.youness.portfolioApp.dto.UserDTO;
import com.youness.portfolioApp.entities.User;
import com.youness.portfolioApp.mapper.UserMapper;
import com.youness.portfolioApp.repositories.UserRepository;
import com.youness.portfolioApp.security.JWTService;
import com.youness.portfolioApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(Long idUser){
        Optional<User> user = userRepository.findById(idUser);
        return this.userMapper.toUserDTO(user.get());
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    @Override
    public UserDTO updateUser(Long idUser, UserDTO userDTO) {
        // Fetch the existing user from the database
        User existingUser = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + idUser));
        // Use the mapper to update only relevant fields from the DTO to the existing entity
        existingUser.setUsername( userDTO.getUsername() );
        existingUser.setFirstname( userDTO.getFirstname() );
        existingUser.setLastname( userDTO.getLastname() );
        existingUser.setEmail( userDTO.getEmail() );
        existingUser.setPhotoUser( userDTO.getPhotoUser() );
        existingUser.setLinkYoutube( userDTO.getLinkYoutube() );
        existingUser.setLinkInstagram( userDTO.getLinkInstagram() );
        existingUser.setLinkSiteWeb( userDTO.getLinkSiteWeb() );
//        existingUser.setCreatedAt( new Date() );
        existingUser.setUpdatedAt( new Date() );
        // Save the updated user entity
        User savedUser = userRepository.save(existingUser);
        // Return the updated UserDTO
        return userMapper.toUserDTO(savedUser);
    }


    @Override
    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public String verify(User user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "fail";
    }
}
