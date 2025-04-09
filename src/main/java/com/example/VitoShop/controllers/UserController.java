package com.example.VitoShop.controllers;

import com.example.VitoShop.DTO.UserCreateRequest;
import com.example.VitoShop.model.UsersEntity;
import com.example.VitoShop.repository.UsersRepository;
import com.example.VitoShop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UsersService usersService;

    //получение пользователя по id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsersEntity>> getUserById(@PathVariable Long id) {
            return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
    }

    //создание нового пользователя
    @PostMapping
    public ResponseEntity<UsersEntity> createUser(@RequestBody UserCreateRequest user) {
        return new ResponseEntity<>(usersService.createUser(user), HttpStatus.CREATED);
    }

    //удаление пользователя
    @GetMapping("/delete/{id}")
    public ResponseEntity<UsersEntity> deleteUserById(@PathVariable Long id) {
        return new ResponseEntity<>(usersService.deleteUser(id), HttpStatus.OK);
    }

}
