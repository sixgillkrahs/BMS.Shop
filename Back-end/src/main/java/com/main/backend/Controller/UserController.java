package com.main.backend.Controller;

import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Users.CreateUpdateUserDto;
import com.main.backend.Domain.Dto.Users.LoginDto;
import com.main.backend.Domain.Dto.Users.UserDto;
import com.main.backend.Domain.Model.Carts.Cart;
import com.main.backend.Domain.Model.Carts.CartItem;
import com.main.backend.Service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("/all")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/save")
    public APIRepository<UserDto> saveUser(@Valid @RequestBody CreateUpdateUserDto input, BindingResult bindingResult) {
        APIRepository<UserDto> repository = new APIRepository<>();

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            repository.setCode(400);
            repository.setMessage(errors.toString());
            repository.setResult(null);
            return repository;
        }

        UserDto savedUser = userService.saveUser(input);

        repository.setCode(1000);
        repository.setResult(savedUser);
        repository.setMessage("User created successfully");
        return repository;
    }


    @GetMapping("/get/{id}")
    public APIRepository<UserDto> getUserById(@PathVariable UUID id){
        APIRepository<UserDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(userService.getUserById(id));
        return repository;
    }

    @PutMapping("/update/{id}")
    public APIRepository<UserDto> updateUser(@PathVariable UUID id, @Valid @RequestBody CreateUpdateUserDto input){
        APIRepository<UserDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(userService.updateUser(id, input));
        return repository;
    }

    @DeleteMapping("/delete/{id}")
    public APIRepository<String> deleteUser(@PathVariable UUID id){
        APIRepository<String> repository = new APIRepository<>();
        repository.setCode(1000);
        userService.deleteUser(id);
        repository.setMessage("delete user successfully");
        return repository;
    }

    @PostMapping("/login")
    public APIRepository<UserDto> Login(@Valid @RequestBody LoginDto input){
        APIRepository<UserDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(userService.login(input));
        repository.setMessage("login successfully");
        return repository;
    }

    @CrossOrigin
    @GetMapping("/cart/{userId}")
    public List<CartItem> getCartItem(@PathVariable UUID userId){
        return userService.getCartItem(userId);
    }


    @CrossOrigin
    @PostMapping("/cart/add")
    public Map<String,String> addToCart(@RequestBody CartItem cartItem){
        System.out.println(cartItem);
        userService.addToCart(cartItem);
        return Map.of("message","Added to cart");
    }

    @CrossOrigin
    @PostMapping("/cart/remove")
    public Map<String,String> removeFromCart(@RequestBody CartItem cartItem){
        userService.removeFromCart(cartItem);
        return Map.of("message","Removed from cart");
    }

    @CrossOrigin
    @GetMapping("/cart/cart/{userId}")
    public Cart getCart(@PathVariable UUID userId){
        return userService.getCart(userId);
    }






}
