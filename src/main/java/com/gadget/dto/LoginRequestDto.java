package com.gadget.dto;

import lombok.Getter;


public record LoginRequestDto(String username,
        String email,
        String password) {

}
