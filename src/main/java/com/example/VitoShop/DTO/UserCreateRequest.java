package com.example.VitoShop.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserCreateRequest {
    private String username;
    private String password;
    private String email;
    private String role;
//    private Set<Long> roles;

}
