package com.example.rewardyourteachersq011bjavapode.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    private String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }
}
