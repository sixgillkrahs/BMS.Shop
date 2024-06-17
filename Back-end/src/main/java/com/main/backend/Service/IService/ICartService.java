package com.main.backend.Service.IService;

import com.main.backend.Domain.Model.Carts.Cart;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ICartService {
    public Cart saveCart(Cart cart);

    public boolean checkCart(UUID userId); ;
}

