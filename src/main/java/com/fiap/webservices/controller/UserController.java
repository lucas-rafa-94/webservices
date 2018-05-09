package com.fiap.webservices.controller;

import com.fiap.webservices.models.ResponseCall;
import com.fiap.webservices.models.User;
import com.fiap.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/insert")
    public ResponseCall insertUser(@RequestBody User user){
        ResponseCall responseCall = new ResponseCall();
        return userService.criaUser(user);
    }
}
