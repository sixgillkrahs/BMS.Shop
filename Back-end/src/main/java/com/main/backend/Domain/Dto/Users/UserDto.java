package com.main.backend.Domain.Dto.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public UUID id;
    public String username;
    public String name;
    public String surname;
    public String email;
    public String password;
    public String phonenumber;
    public String avatarimage;

    public String CreateNormalisedUsername(){
        return this.username.toUpperCase();
    }

    public String CreateNormalisedEmail(){
        return this.email.toUpperCase();
    }

    public Character IsActiveStates(){
        return '1';
    }
}