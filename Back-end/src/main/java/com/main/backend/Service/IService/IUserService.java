package com.main.backend.Service.IService;


import com.main.backend.Domain.Dto.Users.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    public List<UserDto> getAllUser();

}
