package com.gadget.tech.DTO;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class RegistrationRequestDto {
    private String email;
    private String username;
    private String password;
    private String country;
    private LocalDate birthday;

}
