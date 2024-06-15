package com.main.backend.Repository;

import com.main.backend.Domain.Model.Roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, UUID>{
    @Query(value = "select roles.id from roles where roles.id = (select userroles.roleid from userroles  where userroles.userid = :userId)", nativeQuery = true)
    UUID findRoleIdByUserId(UUID userId);
}
