package com.example.notesapplication.notesapplication.service;


import com.example.notesapplication.notesapplication.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(User user);

    UserDetails loadUserByUsername(String username);
    User findByUsername(String username);


    boolean authenticateUser(String password, User user);
}
