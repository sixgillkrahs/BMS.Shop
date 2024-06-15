package com.main.backend.Utils.Mapper;

import com.main.backend.Domain.Dto.Roles.RoleDto;
import com.main.backend.Domain.Model.Roles.Role;

public class RoleMapper {
    public static RoleDto toRoleDto(Role role) {
        return new RoleDto(role.getId(), role.getName());
    }
}
