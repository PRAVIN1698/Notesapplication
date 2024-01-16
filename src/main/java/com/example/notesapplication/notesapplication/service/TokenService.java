package com.example.notesapplication.notesapplication.service;


import com.example.notesapplication.notesapplication.dao.UserRepository;
import com.example.notesapplication.notesapplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {



    private final UserRepository userRepository;

    @Autowired
    public TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean isValidToken(String accessToken) {
        // Placeholder: Implement your logic to check if the access token is valid in the database
        // You may need to verify the token signature, check expiration, and perform database checks
        // Replace the following return statement with your actual validation logic





        //User user = userRepository.findByUsername(username);






        return accessToken != null && !accessToken.isEmpty();
    }




}
