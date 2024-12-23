package com.gadget.tech.services;


import com.gadget.tech.config.SecurityConfig;
import com.gadget.tech.models.UserModel;
import com.gadget.tech.repo.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepositry userRepositry;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public ResponseEntity<String> registerUser(UserModel user) {
        Optional <UserModel> alreadyEmail=userRepositry.findByEmail(user.getEmail());
        Optional <UserModel> alreadyPhone=userRepositry.findByPhoneNumber(user.getPhoneNumber());
        if(alreadyEmail.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        if(alreadyPhone.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Phone number already exists");
        }
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        userRepositry.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User with this info: " + user.getId() +" and name "+ user.getUsername()+ " and Email: "+user.getEmail()+ " registered successfully");
    }

    @Override
    public ResponseEntity<String> loginUser(String email, String password) {
        Optional<UserModel> exists = userRepositry.findByEmail(email);
        if (exists.isPresent()) {
            UserModel user = exists.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return ResponseEntity.ok("Login successful for user: " +user.getUsername() +"\n Email: " +user.getEmail() +  "\n From: " + user.getCountry());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

}
