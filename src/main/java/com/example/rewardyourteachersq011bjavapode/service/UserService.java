package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;

import java.math.BigDecimal;


public interface UserService {
    ApiResponse<String> logoutUser(CustomUserDetails currentUser, String bearerToken);
    BigDecimal currentBalance(Long user_id);

    BigDecimal currentBalance();

    User findUserById(Long user_id);
}
