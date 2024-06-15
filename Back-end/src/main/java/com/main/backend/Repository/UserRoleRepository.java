package com.main.backend.Repository;

import com.main.backend.Domain.Model.UserRoles.UserRole;
import com.main.backend.Domain.Model.UserRoles.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
