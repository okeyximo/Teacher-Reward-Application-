package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;

import java.math.BigDecimal;

public interface UserService {


    ApiResponse<String> logoutUser(CustomUserDetails currentUser, String bearerToken);

    ApiResponse<String> fundWallet(CustomUserDetails currentUserDetails, BigDecimal amount);
}
