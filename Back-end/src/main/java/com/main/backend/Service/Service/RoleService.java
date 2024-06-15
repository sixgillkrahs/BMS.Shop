package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Roles.CreateUpdateRoleDto;
import com.main.backend.Domain.Dto.Roles.RoleDto;
import com.main.backend.Domain.Model.Roles.Role;
import com.main.backend.Repository.RoleRepository;
import com.main.backend.Service.IService.IRoleService;
import com.main.backend.Utils.Exception.ErrorCode;
import com.main.backend.Utils.Exception.HandleRuntimeException;
import com.main.backend.Utils.Mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public RoleDto getRoleById(UUID id) {
        return RoleMapper.toRoleDto(roleRepository.findById(id)
                .orElseThrow(()-> new HandleRuntimeException(ErrorCode.ROLE_NOT_FOUND)));
    }

    @Override
    public RoleDto saveRole(CreateUpdateRoleDto input) {
        Role role = new Role(input.getName(),input.createNormalisedName(),input.getIsdefault());
        roleRepository.save(role);
        return RoleMapper.toRoleDto(role);
    }

    @Override
    public RoleDto updateRole(UUID id, CreateUpdateRoleDto roleDto) {
        return null;
    }


}
