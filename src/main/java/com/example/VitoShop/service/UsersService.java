package com.example.VitoShop.service;

import com.example.VitoShop.DTO.UserCreateRequest;
import com.example.VitoShop.model.Role;
import com.example.VitoShop.model.UsersEntity;
import com.example.VitoShop.repository.RoleRepository;
import com.example.VitoShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepo;

    @Autowired
    RoleRepository roleRepo;

    public Optional<UsersEntity> findById(Long id) {
        return usersRepo.findById(id);
    }



    public UsersEntity deleteUser(Long id) {
         return usersRepo.findById(id).get();
    }


    public UsersEntity createUser(UserCreateRequest user) {
        return null;
    }
}
