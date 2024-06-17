package com.main.backend.Repository;

import com.main.backend.Domain.Model.Options.Color;
import com.main.backend.Domain.Model.Options.Size;
import com.main.backend.Domain.Model.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "select distinct c from Color c ,Product p ,Stock s where p.id = s.productId and s.colorId = c.id and p.id = ?1")
    List<Color> findColorsByProductId(UUID id);

    @Query(value = "select distinct si from Size si ,Product p ,Stock s where p.id = s.productId and s.sizeId = si.id and p.id = ?1")
    List<Size> findSizesByProductId(UUID id);
}
