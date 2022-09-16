package com.example.rewardyourteachersq011bjavapode.controllers;


import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.dto.LogOutRequest;
import com.example.rewardyourteachersq011bjavapode.event.OnUserLogoutSuccessEvent;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.config.Security.JwtUtil;
import com.example.rewardyourteachersq011bjavapode.dto.LoginDTO;
import com.example.rewardyourteachersq011bjavapode.service.CurrentUser;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;
import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.config.Security.JwtUtil;
import com.example.rewardyourteachersq011bjavapode.dto.LoginDTO;
import com.example.rewardyourteachersq011bjavapode.exceptions.ResourceNotFoundException;
import com.example.rewardyourteachersq011bjavapode.response.TeacherRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {


    private final UserService userService;

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final ResponseService<ApiResponse<String>> responseService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody LoginDTO authRequest) throws ResourceNotFoundException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())

            );

        } catch (AuthenticationException ex) {
            log.error(ex.getMessage());
            throw new ResourceNotFoundException("invalid username or password");
        }

        return responseService.response(new ApiResponse<String>("success", LocalDateTime.now(), jwtUtil.generateToken(authRequest.getEmail())), HttpStatus.OK);
    }


    @PutMapping("/logout")
//    public ResponseEntity<?> logoutUser(@CurrentUser CustomUserDetails currentUser, @RequestBody LogOutRequest logOutRequest) {
 public ResponseEntity<?> logoutUser(@RequestBody LogOutRequest logOutRequest) {

        OnUserLogoutSuccessEvent logoutSuccessEvent = new OnUserLogoutSuccessEvent(logOutRequest.getEmail(), logOutRequest.getToken());
        applicationEventPublisher.publishEvent(logoutSuccessEvent);
        String response = logOutRequest.getEmail() + " has successfully logged out from the system!";
        return ResponseEntity.ok(new ApiResponse<String>("success", LocalDateTime.now(), response));

    }

    @PostMapping(value = "/register-student")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserDto userDto) {
        log.info("Successfully Registered {} ", userDto.getEmail());
        return new ResponseEntity<>(userService.registerUser(userDto), CREATED);
    }


    @PostMapping(value = "/register-teacher")
    public ResponseEntity<TeacherRegistrationResponse> registerTeacher(TeacherDto teacherDto, @RequestPart MultipartFile teacherIdImage) throws IOException {
        log.info("Successfully Registered {} ", teacherDto.getEmail());
        return new ResponseEntity<>(userService.registerTeacher(teacherDto, teacherIdImage), CREATED);
    }

}
