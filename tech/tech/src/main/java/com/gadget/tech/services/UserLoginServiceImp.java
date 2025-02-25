package com.gadget.tech.services;

import com.gadget.tech.DTO.LoginRequestDto;
import com.gadget.tech.DTO.LoginResponseDto;
import com.gadget.tech.config.JwtService;
import com.gadget.tech.models.UserModel;
import com.gadget.tech.repo.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImp {
    @Autowired
    UserRepositry userRepositry;
    @Autowired
    JwtService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseEntity<?> login(LoginRequestDto loginRequestDto) {
        Optional<UserModel> user = userRepositry.findByUsernameOrEmail(loginRequestDto.getUsername(), loginRequestDto.getEmail());
        if(user.isEmpty()) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        UserModel userModel = user.get();
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), userModel.getPassword())) {
            return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
        }
        String token = jwtService.generateToken(loginRequestDto.getUsername());
        return new ResponseEntity<>(new LoginResponseDto(token), HttpStatus.OK);



    }
}
