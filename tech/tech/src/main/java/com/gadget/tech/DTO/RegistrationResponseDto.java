package com.gadget.tech.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class RegistrationResponseDto {
    private String email;
    private String username;
    private String password;
    private String country;
    private LocalDate birthday;


    public RegistrationResponseDto(String email, String username, String password, String country, LocalDate birthday) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.country = country;
        this.birthday = birthday;

    }
}
