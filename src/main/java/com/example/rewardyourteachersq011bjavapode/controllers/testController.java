package com.example.rewardyourteachersq011bjavapode.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class testController {
    @GetMapping
    public String helloApi(){
        return "reward your teacher";
    }

    @PostMapping("/hello")
    public String hello(@PathVariable(name="hello") String mssg){
        return mssg;
    }
}
