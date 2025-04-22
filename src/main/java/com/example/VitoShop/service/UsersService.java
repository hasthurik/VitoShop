package com.example.VitoShop.service;

import com.example.VitoShop.DTO.UserCreateRequest;
import com.example.VitoShop.DTO.UserDTO;
import com.example.VitoShop.mapper.UserMapper;
import com.example.VitoShop.entity.UsersEntity;
import com.example.VitoShop.repository.RoleRepository;
import com.example.VitoShop.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UsersService {



    private final UsersRepository usersRepo;

    private final RoleRepository roleRepo;

    private final UserMapper userMapper;


    public Optional<UsersEntity> findById(Long id) {
        return usersRepo.findById(id);
    }

    public UsersEntity deleteUser(Long id) {
         return usersRepo.findById(id).get();
    }

    public UsersEntity createUser(UserCreateRequest user) {
        UsersEntity userBuild = new UsersEntity();
        userBuild.setUsername(user.getUsername());
        userBuild.setPassword(user.getPassword());
        userBuild.setEmail(user.getEmail());

        return usersRepo.save(userBuild);
    }

    public ResponseEntity<UserDTO> getUserById(Long id) {
        Optional<UsersEntity> usersEntity = usersRepo.findById(id);
        UserDTO userDTO = userMapper.userEntityToUserDTO(usersEntity.get());
        return userDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    public List<UsersEntity> getAllUser() {
        return usersRepo.findAll();
    }
}
