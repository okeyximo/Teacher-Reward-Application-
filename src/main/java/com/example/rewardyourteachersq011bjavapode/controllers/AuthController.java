package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.GoogleOAuth2UserDto;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.config.Security.JwtUtil;
import com.example.rewardyourteachersq011bjavapode.dto.LoginDto;
import com.example.rewardyourteachersq011bjavapode.exception.ResourceNotFoundException;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final ResponseService<ApiResponse<String>> responseService;


    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginDto authRequest) throws ResourceNotFoundException {
        log.info("Got here");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())

            );

        } catch (AuthenticationException ex) {
            log.error(ex.getMessage());
            throw new ResourceNotFoundException("invalid username or password");
        }
        return  responseService.response(new ApiResponse<String>("success" , LocalDateTime.now() , jwtUtil.generateToken(authRequest.getEmail())) , HttpStatus.OK);
    }

    @PostMapping("/oauth2/callback")
    public ResponseEntity<ApiResponse> authenticateOauth2(@RequestBody GoogleOAuth2UserDto principal){
        return  userService.OAuth2Authenticate(principal);
    }

}
