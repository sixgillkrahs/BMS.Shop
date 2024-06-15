package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Roles.RoleDto;
import com.main.backend.Domain.Model.Roles.Role;
import com.main.backend.Repository.RoleRepository;
import com.main.backend.Service.IService.IRoleService;
import com.main.backend.Utils.Mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleService implements IRoleService {

    @Autowired
    public RoleRepository roleRepository;


    @Override
    public List<RoleDto> getAllRole() {
        List<RoleDto> roleDtoList = new ArrayList<>();
        for (Role role : roleRepository.findAll()){
            roleDtoList.add(RoleMapper.toRoleDto(role));
        }
        return roleDtoList;
    }


}
