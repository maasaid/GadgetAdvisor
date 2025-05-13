package com.gadget.controller;

import com.gadget.dto.LoginRequestDto;
import com.gadget.dto.LoginResponseDto;
import com.gadget.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLoginService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(
            @RequestBody final LoginRequestDto authenticationRequestDto
    ) {
        return ResponseEntity.ok(
                authenticationService.authenticate(authenticationRequestDto));
    }
}

