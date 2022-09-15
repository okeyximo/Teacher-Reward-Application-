package com.example.rewardyourteachersq011bjavapode.response;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class LogOutRequest {

//    @Valid
//    @NotNull(message = "Device info cannot be null")
//    private DeviceInfo deviceInfo;
    
    @Valid
    @NotNull(message = "Existing Token needs to be passed")
    private String token;
}