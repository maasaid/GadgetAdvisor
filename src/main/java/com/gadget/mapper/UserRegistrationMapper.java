package com.gadget.mapper;

import com.gadget.dto.RegistrationRequestDto;
import com.gadget.dto.RegistrationResponseDto;
import com.gadget.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {

    public UserModel toEntity(RegistrationRequestDto registrationRequestDto) {
        final var user = new UserModel();

        user.setEmail(registrationRequestDto.email());
        user.setUsername(registrationRequestDto.username());
        user.setPassword(registrationRequestDto.password());
        user.setCountry(registrationRequestDto.country());
        user.setBirthday(registrationRequestDto.birthday());
        return user;
    }

    public RegistrationResponseDto toRegistrationResponseDto(
            final UserModel user) {

        return new RegistrationResponseDto(
                user.getEmail(), user.getUsername(), user.getCountry(), user.getBirthday());
    }

}
