package com.gadget.tech.services;

import com.gadget.tech.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ResponseEntity<String> registerUser(UserModel user);
    public ResponseEntity<String> loginUser(String Email, String Password);
}
