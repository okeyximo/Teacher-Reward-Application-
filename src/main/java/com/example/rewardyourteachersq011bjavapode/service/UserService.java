package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.GoogleOAuth2UserDto;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;

import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;

public interface UserService {

    UserRegistrationResponse registerUser(UserDto userDto);

    TeacherRegistrationResponse registerTeacher(TeacherDto teacherDto, MultipartFile teacherId) throws IOException;

    ApiResponse<String> logoutUser(CustomUserDetails currentUser, String bearerToken);
}
