package com.example.VitoShop.controllers;

import com.example.VitoShop.DTO.UserCreateRequest;
import com.example.VitoShop.DTO.UserDTO;
import com.example.VitoShop.entity.UsersEntity;
import com.example.VitoShop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }


//    //получение пользователя по id
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<UsersEntity>> getUserById(@PathVariable Long id) {
//            return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
//    }

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

    //dto по id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    //Получение данных всех пользователй
    @GetMapping("/all")
    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUser(), HttpStatus.OK);
    }

}
