package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.response.ExceptionResponse;
import com.example.rewardyourteachersq011bjavapode.exception.ResourceNotFoundException;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    private final ResponseService<ExceptionResponse> responseService;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(ResourceNotFoundException exception){
        return responseService.response(new ExceptionResponse(exception.getMessage(), LocalDateTime.now() , HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
