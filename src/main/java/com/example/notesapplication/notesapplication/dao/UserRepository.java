package com.example.notesapplication.notesapplication.dao;


import com.example.notesapplication.notesapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
