package com.main.backend.Repository;

import com.main.backend.Domain.Model.Carts.CartItem;
import com.main.backend.Domain.Model.Carts.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
    @Query("SELECT c FROM CartItem c WHERE c.cartid = ?1")
    List<CartItem> findByCartItemId(UUID cartidUuid);
}