package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Users.CreateUpdateUserDto;
import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Domain.Model.Roles.Role;
import com.main.backend.Domain.Model.UserRoles.UserRole;
import com.main.backend.Domain.Model.Users.User;
import com.main.backend.Repository.RoleRepository;
import com.main.backend.Repository.UserRepository;
import com.main.backend.Repository.UserRoleRepository;
import com.main.backend.Service.IService.IUserService;
import com.main.backend.Utils.Exception.ErrorCode;
import com.main.backend.Utils.Exception.HandleRuntimeException;
import com.main.backend.Utils.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements IUserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RoleRepository roleRepository;
    @Autowired
    public UserRoleRepository userRoleRepository;


    @Override
    public List<UserDto> getAllUser() {
        List <UserDto> userDtoList = new ArrayList<>();
        for (User user : userRepository.findAll()){
            userDtoList.add(UserMapper.toUserDto(user));
        }
        return userDtoList;
    }

    @Override
    public UserDto saveUser(CreateUpdateUserDto input) {
        if(userRepository.existsByEmail(input.getEmail())){
            throw new HandleRuntimeException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        PasswordEncoder pass = new BCryptPasswordEncoder(10);
        User newUser = new User(
                input.getUsername(),
                input.createnormalizedusername(),
                input.getName(),
                input.getSurname(),
                input.getEmail(),
                input.createnormalizedemail(),
                pass.encode(input.getPassword()),
                input.getPhonenumber(),
                input.getPhonenumber(),
                input.isactivestates(),
                "http://localhost:9900/shop/avatar/default_avatar.jpg"
        );
        userRepository.save(newUser);
        Role role = new Role();
        for(Role r : roleRepository.findAll()){
            if(r.isdefault == '1'){
                role = r;
            }
        }
        UserRole userRoles = new UserRole(newUser.getId(), role.getId());
        userRoleRepository.save(userRoles);
        return UserMapper.toUserDto(newUser);
    }

}
