package com.youness.portfolioApp.controllers;

import com.youness.portfolioApp.dto.UserDTO;
import com.youness.portfolioApp.entities.User;
import com.youness.portfolioApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")  // Autoriser les requêtes depuis Angular
@RestController
@RequestMapping("/api") // Optional base path
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.findUsers();
    }

    @GetMapping("/user/{idUser}")
    public UserDTO getUser(@PathVariable Long idUser){
        return userService.getUser(idUser);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update/{idUser}")
    public UserDTO updateUser(@PathVariable Long idUser, @RequestBody UserDTO userDTO){
        userDTO.setIdUser(userDTO.getIdUser());
        return userService.updateUser(idUser, userDTO);
    }

    @DeleteMapping("/deleteUser/{idUser}")
    public void deleteUser(@PathVariable Long idUser){
        userService.deleteUser(idUser);
    }

    @PostMapping("/auth")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }

}
