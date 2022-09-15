package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.GoogleOAuth2UserDto;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import org.springframework.http.ResponseEntity;


public interface UserService {

    public ResponseEntity<ApiResponse> OAuth2Authenticate(GoogleOAuth2UserDto principal);

}
