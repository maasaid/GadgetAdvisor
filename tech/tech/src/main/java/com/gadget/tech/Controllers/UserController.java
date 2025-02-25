package com.gadget.tech.Controllers;

import com.gadget.tech.DTO.*;
import com.gadget.tech.config.JwtService;
import com.gadget.tech.models.UserModel;
import com.gadget.tech.repo.UserRepositry;
import com.gadget.tech.services.UserLoginServiceImp;
import com.gadget.tech.services.UserRegistrationServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/GadgetAdvisor")
public class UserController {

    @Autowired
    UserRepositry userRepositry;
    @Autowired
    UserRegistrationServiceImp userService;
    @Autowired
    private UserLoginServiceImp userLoginServiceImp;

    @GetMapping
    public List<UserModel> getAllUsers() {
       return userRepositry.findAll();
    }

    @PostMapping("/register")
    public  ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequestDto registrationDTO) {
        return userService.registerUserSer(registrationDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {
        return userLoginServiceImp.login(request);
    }
}
