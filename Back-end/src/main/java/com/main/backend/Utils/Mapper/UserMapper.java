package com.main.backend.Utils.Mapper;

import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Domain.Model.Users.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getSurname(), user.getEmail(),user.getPassword(), user.getPhonenumber(),user.getAvatarimage());
    }
}
