package com.main.backend.Domain.Dto.Roles;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class CreateUpdateRoleDto {

    private String name;
    private Character isdefault;

    public String createNormalisedName(){
        return this.name.toUpperCase();
    }
}
