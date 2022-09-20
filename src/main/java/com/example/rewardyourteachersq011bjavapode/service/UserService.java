package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
public interface UserService {
    ApiResponse<String> logoutUser(CustomUserDetails currentUser, String bearerToken);
}
