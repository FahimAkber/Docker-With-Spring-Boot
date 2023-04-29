package com.example.dockerwithspringboot.service;

import com.example.dockerwithspringboot.dto.UserRequest;
import com.example.dockerwithspringboot.dto.UserResponse;
import com.example.dockerwithspringboot.entity.User;
import com.example.dockerwithspringboot.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return Stream.of(userRepository.save(user)).map(entity ->
                    new UserResponse(entity.getId(), entity.getUserName(), entity.getMobileNumber()))
                .findFirst()
                .orElseThrow( () -> new RuntimeException("Entity not found."));
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(entity ->
                                                        new UserResponse(entity.getId(), entity.getUserName(), entity.getMobileNumber()))
                                                .collect(Collectors.toList());
    }


    @Override
    public UserResponse getUserByMobileNo(String mobileNo) {
        return Stream.of(userRepository.findByMobileNumber(mobileNo)).map(entity ->
                        new UserResponse(entity.getId(), entity.getUserName(), entity.getMobileNumber()))
                .findFirst()
                .orElseThrow( () -> new RuntimeException("Entity not found."));
    }
}
