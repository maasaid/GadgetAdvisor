package com.gadget.mapper;

import com.gadget.dto.UserProfileDto;
import com.gadget.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserProfileDto toUserProfileDto(final UserModel user) {
        return new UserProfileDto(user.getEmail(), user.getUsername());
    }

}
