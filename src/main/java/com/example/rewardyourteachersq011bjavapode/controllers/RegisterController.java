package com.example.rewardyourteachersq011bjavapode.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @GetMapping(value = "/register-student")
    public String register(){
        return "Registered";
    }

    @GetMapping(value = "/register-any")
    public String registerAny(){
        return "Registered Any";
    }
}
