package com.gadget.dto;

import java.time.LocalDate;

public record RegistrationRequestDto(
        String email,
        String username,
        String password,
        String country,
        LocalDate birthday
) {

}
