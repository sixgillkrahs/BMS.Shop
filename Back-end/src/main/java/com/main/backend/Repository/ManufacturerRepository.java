package com.main.backend.Repository;

import com.main.backend.Domain.Model.Manufacturers.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID> {
    boolean existsByName(String name);
}
