package com.gadget.dto;


import java.time.LocalDate;

public record RegistrationResponseDto(String email,
                                      String username,
                                      String country,
                                      LocalDate birthday
) {}
