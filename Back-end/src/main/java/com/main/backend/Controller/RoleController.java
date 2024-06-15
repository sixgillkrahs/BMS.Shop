package com.main.backend.Controller;

import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Roles.RoleDto;
import com.main.backend.Service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @RequestMapping("/all")
    public APIRepository<List<RoleDto>> getAllRole(){
        APIRepository<List<RoleDto>> apiRepository = new APIRepository<>();
        apiRepository.setCode(1000);
        apiRepository.setResult(roleService.getAllRole());
        return apiRepository;
    }


}
