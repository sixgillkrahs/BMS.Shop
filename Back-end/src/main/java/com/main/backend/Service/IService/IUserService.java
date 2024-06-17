package com.main.backend.Service.IService;


import com.main.backend.Domain.Dto.Users.CreateUpdateUserDto;
import com.main.backend.Domain.Dto.Users.LoginDto;
import com.main.backend.Domain.Dto.Users.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IUserService {

    public List<UserDto> getAllUser();
    public UserDto saveUser(CreateUpdateUserDto input);
    public UserDto getUserById(UUID id);
    public UserDto updateUser(UUID id, CreateUpdateUserDto input);
    public void deleteUser(UUID id);
    public boolean login(LoginDto loginDto);
}
