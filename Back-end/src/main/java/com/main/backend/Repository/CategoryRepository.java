package com.main.backend.Repository;

import com.main.backend.Domain.Model.Categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;


@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, UUID>{
    boolean existsByName(String name);
    List<Category> findAllByParentId(UUID parentId);
}
