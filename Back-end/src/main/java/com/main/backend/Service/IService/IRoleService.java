package com.main.backend.Service.IService;

import com.main.backend.Domain.Dto.Roles.RoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoleService {

    public List<RoleDto> getAllRole();
}
