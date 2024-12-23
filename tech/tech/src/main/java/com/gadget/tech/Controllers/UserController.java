package com.gadget.tech.Controllers;

import com.gadget.tech.DTO.LoginRequest;
import com.gadget.tech.models.UserModel;
import com.gadget.tech.repo.UserRepositry;
import com.gadget.tech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/GadgetAdvisor")
public class UserController {
    @Autowired
    UserRepositry userRepositry;
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserModel> getAllUsers() {
       return userRepositry.findAll();
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserModel userModel) {return userService.registerUser(userModel);}
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
