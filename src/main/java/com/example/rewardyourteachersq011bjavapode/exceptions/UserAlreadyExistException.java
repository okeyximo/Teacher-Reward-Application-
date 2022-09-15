package com.example.rewardyourteachersq011bjavapode.exceptions;

import lombok.Getter;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
