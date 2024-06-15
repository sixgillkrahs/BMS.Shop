package com.main.backend.Controller;

import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    public UserService userService;

    
    @GetMapping("/all")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }




}
