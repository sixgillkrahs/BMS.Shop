package com.main.backend.Controller;

import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Roles.CreateUpdateRoleDto;
import com.main.backend.Domain.Dto.Roles.RoleDto;
import com.main.backend.Service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
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

    @PostMapping("/save")
    public APIRepository<RoleDto> saveRole(@RequestBody CreateUpdateRoleDto input){
        APIRepository<RoleDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(roleService.saveRole(input));
        repository.setMessage("create role successfully");
        return repository;
    }

    @GetMapping("/get/{id}")
    public APIRepository<RoleDto> getRoleById(@PathVariable UUID id){
        APIRepository<RoleDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(roleService.getRoleById(id));
        return repository;
    }

    @PutMapping("/update/{id}")
    public APIRepository<RoleDto> updateRole(@PathVariable UUID id, @RequestBody CreateUpdateRoleDto input){
        APIRepository<RoleDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(roleService.updateRole(id,input));
        repository.setMessage("update role successfully");
        return repository;
    }

    @DeleteMapping("/delete/{id}")
    public APIRepository<String> deleteRole(@PathVariable UUID id){
        APIRepository<String> repository = new APIRepository<>();
        roleService.deleteRole(id);
        repository.setCode(1000);
        repository.setMessage("delete role successfully");
        return repository;
    }


}
