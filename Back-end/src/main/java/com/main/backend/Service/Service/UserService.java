package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Domain.Model.Users.User;
import com.main.backend.Repository.UserRepository;
import com.main.backend.Service.IService.IUserService;
import com.main.backend.Utils.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements IUserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<UserDto> getAllUser() {
        List <UserDto> userDtoList = new ArrayList<>();
        for (User user : userRepository.findAll()){
            userDtoList.add(UserMapper.toUserDto(user));
        }
        return userDtoList;
    }

}
