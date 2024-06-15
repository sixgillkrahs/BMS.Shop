package com.main.backend.Repository;

import com.main.backend.Domain.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    User findByUsername(String username);
}