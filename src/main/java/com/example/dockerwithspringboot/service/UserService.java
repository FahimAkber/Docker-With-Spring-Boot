package com.example.dockerwithspringboot.service;

import com.example.dockerwithspringboot.dto.UserRequest;
import com.example.dockerwithspringboot.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);
    List<UserResponse> getUsers();
    UserResponse getUserByMobileNo(String mobileNo);
}
