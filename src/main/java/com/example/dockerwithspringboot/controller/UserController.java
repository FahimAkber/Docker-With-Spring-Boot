package com.example.dockerwithspringboot.controller;

import com.example.dockerwithspringboot.dto.UserRequest;
import com.example.dockerwithspringboot.service.UserService;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveUser(@RequestBody UserRequest userRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(userService.saveUser(userRequest), headers ,HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(userService.getUsers(), headers ,HttpStatus.OK);

    }

    @GetMapping("/{mobileNumber}")
    public ResponseEntity<Object> getUsers(@PathVariable("mobileNumber") String mobileNumber){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(userService.getUserByMobileNo(mobileNumber), headers ,HttpStatus.OK);

    }
}
