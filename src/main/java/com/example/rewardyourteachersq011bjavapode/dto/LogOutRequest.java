package com.example.rewardyourteachersq011bjavapode.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class LogOutRequest {

    @Valid
    @NotNull(message = "Existing Token needs to be passed")
    private String token;
}