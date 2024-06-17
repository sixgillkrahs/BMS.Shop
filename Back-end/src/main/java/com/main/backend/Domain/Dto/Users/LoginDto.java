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
public class LoginDto {
    @Email(message = "Email should be valid")
    public String email;
    @Size(min = 8, max = 20 ,message = "Password must be between 8 and 20 characters")
    public String password;
}
