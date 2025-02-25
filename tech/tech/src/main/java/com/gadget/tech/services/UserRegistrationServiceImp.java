package com.gadget.tech.services;

import com.gadget.tech.DTO.RegistrationRequestDto;
import com.gadget.tech.models.UserModel;
import com.gadget.tech.repo.UserRepositry;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImp{
    @Autowired
    private  final UserRepositry userRepositry;
    @Autowired
    private  final PasswordEncoder passwordEncoder;

    public ResponseEntity<?> registerUserSer(RegistrationRequestDto request) {
        if (userRepositry.existsUserModelByUsername(request.getUsername())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        if (userRepositry.existsUserModelByEmail(request.getEmail())){
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }
        Instant now = Instant.now();
        UserModel user = new UserModel();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setBirthday(request.getBirthday());
        user.setCountry(request.getCountry());
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        userRepositry.save(user);
        return new ResponseEntity<>("The User "+user.getUsername()+" with Email "+user.getEmail() +" is registered successfully", HttpStatus.CREATED);
    }
}
