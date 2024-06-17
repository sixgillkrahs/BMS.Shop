package com.main.backend.Service.Service;


import com.main.backend.Domain.Model.Carts.Cart;
import com.main.backend.Repository.CartRepository;
import com.main.backend.Service.IService.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartService implements ICartService {

    @Autowired
    public CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public boolean checkCart(UUID userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            return false;
        }
        return true;
    }
}