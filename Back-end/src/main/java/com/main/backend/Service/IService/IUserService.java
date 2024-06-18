package com.main.backend.Service.IService;


import com.main.backend.Domain.Dto.Users.CreateUpdateUserDto;
import com.main.backend.Domain.Dto.Users.LoginDto;
import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Domain.Model.Carts.Cart;
import com.main.backend.Domain.Model.Carts.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IUserService {

    public List<UserDto> getAllUser();
    public UserDto saveUser(CreateUpdateUserDto input);
    public UserDto getUserById(UUID id);
    public UserDto updateUser(UUID id, CreateUpdateUserDto input);
    public void deleteUser(UUID id);
    public UserDto login(LoginDto loginDto);
    public List<CartItem> getCartItem(UUID userId);
    public void addToCart(CartItem cartItem);

    public void removeFromCart(CartItem cartItem);

    public Cart getCart(UUID userId);
}
