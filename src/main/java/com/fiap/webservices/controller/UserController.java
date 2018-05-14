package com.fiap.webservices.controller;

import com.fiap.webservices.models.business.ResponseCall;
import com.fiap.webservices.models.canonical.Usuario;
import com.fiap.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseCall insertUser(@RequestBody Usuario usuario){
        return userService.createUser(usuario);
    }

}
