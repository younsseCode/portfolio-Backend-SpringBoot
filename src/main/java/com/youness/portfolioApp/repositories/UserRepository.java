package com.youness.portfolioApp.repositories;

import com.youness.portfolioApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

//    UserDTO save(UserDTO userDTO);
//    Optional<User> findById(Long id);
//    List<User> findAll();
//    void delete(UserDTO userDTO);

}
