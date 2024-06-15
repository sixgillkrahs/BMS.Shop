package com.main.backend.Domain.Dto.Users;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateUserDto {
    @Size(min = 8, max = 20 ,message = "Username must be between 8 and 20 characters")
    public String username;
    public String name;
    public String surname;
    @Email(message = "Email should be valid")
    public String email;
    @Size(min = 10, max = 10 ,message = "Phone number must be 10 characters")
    public String phonenumber;
    @Size(min = 8, max = 20 ,message = "Password must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[A-Z]).*$", message = "Password must contain at least one uppercase letter")
    public String password;
    public String avatarimage;

    public String createnormalizedusername(){
        return this.username.toUpperCase();
    }

    public String createnormalizedemail(){
        return this.email.toUpperCase();
    }

    public Character isactivestates(){
        return '1';
    }


}
