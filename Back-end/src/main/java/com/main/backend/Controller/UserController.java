package com.main.backend.Controller;

import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Users.CreateUpdateUserDto;
import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public APIRepository<UserDto> saveUser(@Valid @RequestBody CreateUpdateUserDto input){
        APIRepository<UserDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(userService.saveUser(input));
        repository.setMessage("create user successfully");
        return repository;
    }




}
