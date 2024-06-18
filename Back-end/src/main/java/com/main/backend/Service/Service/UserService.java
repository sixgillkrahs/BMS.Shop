package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Users.CreateUpdateUserDto;
import com.main.backend.Domain.Dto.Users.LoginDto;
import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Domain.Model.Carts.Cart;
import com.main.backend.Domain.Model.Carts.CartItem;
import com.main.backend.Domain.Model.Carts.CartItemId;
import com.main.backend.Domain.Model.Roles.Role;
import com.main.backend.Domain.Model.UserRoles.UserRole;
import com.main.backend.Domain.Model.UserRoles.UserRoleId;
import com.main.backend.Domain.Model.Users.User;
import com.main.backend.Repository.*;
import com.main.backend.Service.IService.IUserService;
import com.main.backend.Utils.Exception.ErrorCode;
import com.main.backend.Utils.Exception.HandleRuntimeException;
import com.main.backend.Utils.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserService implements IUserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RoleRepository roleRepository;
    @Autowired
    public UserRoleRepository userRoleRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;


    @Override
    public List<UserDto> getAllUser() {
        List <UserDto> userDtoList = new ArrayList<>();
        for (User user : userRepository.findAll()){
            userDtoList.add(UserMapper.toUserDto(user));
        }
        return userDtoList;
    }

    @Override
    public UserDto saveUser(CreateUpdateUserDto input) {
        if(userRepository.existsByEmail(input.getEmail())){
            throw new HandleRuntimeException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        PasswordEncoder pass = new BCryptPasswordEncoder(10);
        User newUser = new User(
                input.getUsername(),
                input.createnormalizedusername(),
                input.getName(),
                input.getSurname(),
                input.getEmail(),
                input.createnormalizedemail(),
                pass.encode(input.getPassword()),
                input.getPhonenumber(),
                input.getPhonenumber(),
                input.isactivestates(),
                "http://localhost:9900/shop/avatar/default_avatar.jpg"
        );
        userRepository.save(newUser);
        Role role = new Role();
        for(Role r : roleRepository.findAll()){
            if(r.isdefault == '1'){
                role = r;
            }
        }
        UserRole userRoles = new UserRole(newUser.getId(), role.getId());
        userRoleRepository.save(userRoles);
        return UserMapper.toUserDto(newUser);
    }

    @Override
    public UserDto getUserById(UUID id) {
        return UserMapper.toUserDto(userRepository.findById(id)
                .orElseThrow(()-> new HandleRuntimeException(ErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public UserDto updateUser(UUID id, CreateUpdateUserDto input) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new HandleRuntimeException(ErrorCode.USER_NOT_FOUND));
        PasswordEncoder pass = new BCryptPasswordEncoder(10);
        user.setUsername(input.getUsername());
        user.setNormalizedusername(input.createnormalizedusername());
        user.setName(input.getName());
        user.setSurname(input.getSurname());
        user.setEmail(input.getEmail());
        user.setNormalizedemail(input.createnormalizedemail());
        user.setPassword(pass.encode(input.getPassword()));
        user.setPhonenumber(input.getPhonenumber());
        user.setIsactive(input.isactivestates());
        user.setAvatarimage(input.getAvatarimage());
        userRepository.save(user);
        return UserMapper.toUserDto(user) ;
    }

    @Override
    public void deleteUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new HandleRuntimeException(ErrorCode.USER_NOT_FOUND));
        UUID roleId =  roleRepository.findRoleIdByUserId(id);
        UserRoleId userRoleId = new UserRoleId(id,roleId);
        userRoleRepository.deleteById(userRoleId);
        userRepository.delete(user);
    }

    @Override
    public UserDto login(LoginDto loginDto) {
        System.out.println(loginDto.email);
        User user = userRepository.findByEmail(loginDto.email).orElseThrow(() -> new HandleRuntimeException(ErrorCode.EMAIL_NOT_FOUND));
        PasswordEncoder pass = new BCryptPasswordEncoder(10);
        if(!pass.matches(loginDto.getPassword(), user.getPassword())){
            throw new HandleRuntimeException(ErrorCode.WRONG_PASSWORD);
        }
        Cart cart = cartRepository.findByUserId(user.getId());
        if(cart == null){
            cart = new Cart();
            cart.setUserId(user.getId());
            cart.setUserName(user.getName());
            cart.setUserAddress("Hà Nội");
            cart.setUserPhone(user.getPhonenumber());
            cart.setStatus(0);
            cart.setShippingFee(0);
            cart.setTotal(0);
            cart.setDiscount(0);
            cartRepository.save(cart);
        }
        return UserMapper.toUserDto(user);
    }

    @Override
    public List<CartItem> getCartItem(UUID userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if(cart != null){
            List<CartItem> cartItemList = cartItemRepository.findByCartItemId(cart.getId());
            return cartItemList;
        }
        return List.of();
    }

    public void addToCart(CartItem cartItem){
        CartItemId cartItemId = new CartItemId(cartItem.getCartid(), cartItem.getProductid(),cartItem.getColorid(),cartItem.getSizeid());
        CartItem cartItem1 = cartItemRepository.findById(cartItemId).orElse(null);
        if(cartItem1 == null){
            cartItem1 = new CartItem();
            cartItem1.setCartid(cartItem.getCartid());
            cartItem1.setProductid(cartItem.getProductid());
            cartItem1.setQuantity(cartItem.getQuantity());
            cartItem1.setPrice(cartItem.getPrice());
            cartItem1.setSizeid(cartItem.getSizeid());
            cartItem1.setColorid(cartItem.getColorid());
            cartItem1.setProductname(cartItem.getProductname());
            cartItem1.setColorname(stockService.getNameColorbyId(cartItem.getColorid()));
            cartItem1.setSizename(stockService.getNameSizebyId(cartItem.getSizeid()));
            cartItem1.setThumnailimage(productService.getThumnailImage(cartItem.getProductid()));
            cartItemRepository.save(cartItem1);
            Cart cart = cartRepository.findById(cartItem1.getCartid()).get();
            cart.setTotal(cart.getTotal() + (cartItem.getQuantity() * cartItem.getPrice()));
            cartRepository.save(cart);
            return;
        }
        Cart cart = cartRepository.findById(cartItem.getCartid()).get();
        cart.setTotal(cart.getTotal() + cartItem.getQuantity() * cartItem.getPrice());
        System.out.println(cartItem1);
        cartItem1.setQuantity(cartItem1.getQuantity() + cartItem.getQuantity());
        cartItemRepository.save(cartItem1);
    }


    @Override
    public void removeFromCart(CartItem cartItem) {
        CartItemId cartItemId = new CartItemId(cartItem.getCartid(), cartItem.getProductid(),cartItem.getColorid(),cartItem.getSizeid());
        CartItem cartItem1 = cartItemRepository.findById(cartItemId).orElse(null);
        if(cartItem1 != null){
            Cart cart = cartRepository.findById(cartItem1.getCartid()).get();
            cart.setTotal(cart.getTotal() - cartItem1.getQuantity() * cartItem1.getPrice());
            cartRepository.save(cart);
            cartItemRepository.deleteById(cartItemId);
        }
    }

    @Override
    public Cart getCart(UUID userId) {
        return cartRepository.findByUserId(userId);
    }

}
