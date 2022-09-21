package com.example.rewardyourteachersq011bjavapode.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RegisterController {

    @GetMapping
    public String googleLogin(){
        return "Login Successful; and highly You are Welcome!!";
    }

    @GetMapping("/user")
    public Principal user (Principal principal){
        System.out.println("LoginUserName:" + principal.getName());
        return principal;
    }

}
