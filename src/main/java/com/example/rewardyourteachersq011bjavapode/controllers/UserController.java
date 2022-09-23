package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.service.CurrentUser;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser(@CurrentUser CustomUserDetails currentUser, @RequestHeader("Authorization") String bearToken) {
        return new ResponseEntity<>(userService.logoutUser(currentUser, bearToken), OK);
    }

//    @GetMapping("/wallet/{user_id}")
//    public ResponseEntity<?> currentUserBalance(@PathVariable(value ="user_id") Long user_id){
//        return new ResponseEntity<>(userService.currentBalance(user_id),OK);
//    }


    @GetMapping("/wallet")
    public ResponseEntity<?> currentUserBalance(){
        return new ResponseEntity<>(userService.currentBalance(),OK);
    }


}