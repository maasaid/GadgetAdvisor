package com.gadget.service;

import com.gadget.dto.LoginRequestDto;
import com.gadget.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public LoginResponseDto authenticate(
            final LoginRequestDto request) {

        final var authToken = UsernamePasswordAuthenticationToken
                .unauthenticated(request.username(), request.password());

        final var authentication = authenticationManager
                .authenticate(authToken);

        final var token = jwtService.generateToken(request.username());
        return new LoginResponseDto(token);
    }
}


