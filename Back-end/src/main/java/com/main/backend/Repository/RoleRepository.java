package com.main.backend.Repository;

import com.main.backend.Domain.Model.Roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, UUID>{

}
