package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.PrincipalDto;
import com.example.rewardyourteachersq011bjavapode.dto.TeacherRegistrationDto;
import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.config.Security.JwtUtil;
import com.example.rewardyourteachersq011bjavapode.dto.LoginDTO;
import com.example.rewardyourteachersq011bjavapode.exceptions.ResourceNotFoundException;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.service.AuthService;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    private final JwtUtil jwtUtil;



    private final ResponseService<ApiResponse<PrincipalDto>> responseService;
    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody LoginDTO authRequest) throws ResourceNotFoundException {
        return  responseService.response(authService.loginUser(authRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/register-student")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserDto userDto) {
        log.info("Successfully Registered {} ", userDto.getEmail());
        return new ResponseEntity<>(authService.registerUser(userDto), CREATED);
    }


    @PostMapping(value = "/register-teacher")
    public ResponseEntity<UserRegistrationResponse> registerTeacher(TeacherRegistrationDto teacherDto, @RequestPart MultipartFile teacherIdImage) throws IOException {
        log.info("Successfully Registered {} ", teacherDto.getEmail());
        return new ResponseEntity<>(authService.registerTeacher(teacherDto, teacherIdImage), CREATED);
    }

}
