package com.main.backend.Service.IService;

import com.main.backend.Domain.Dto.Roles.CreateUpdateRoleDto;
import com.main.backend.Domain.Dto.Roles.RoleDto;
import com.main.backend.Domain.Model.Roles.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IRoleService {

    public List<RoleDto> getAllRole();

    public RoleDto getRoleById(UUID id);

    public RoleDto saveRole(CreateUpdateRoleDto roleDto);

    public RoleDto updateRole(UUID id, CreateUpdateRoleDto roleDto);

    public void deleteRole(UUID id);
}
