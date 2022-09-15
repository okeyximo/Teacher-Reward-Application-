package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.dto.LogOutRequest;
import com.example.rewardyourteachersq011bjavapode.event.OnUserLogoutSuccessEvent;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.config.Security.JwtUtil;
import com.example.rewardyourteachersq011bjavapode.dto.LoginDTO;
import com.example.rewardyourteachersq011bjavapode.exception.ResourceNotFoundException;
import com.example.rewardyourteachersq011bjavapode.service.CurrentUser;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final ResponseService<ApiResponse<String>> responseService;
    private final ApplicationEventPublisher applicationEventPublisher;
    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginDTO authRequest) throws ResourceNotFoundException {
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


    @PutMapping("/logout")
    public ResponseEntity<?> logoutUser(@CurrentUser CustomUserDetails currentUser, @RequestBody LogOutRequest logOutRequest) {

        OnUserLogoutSuccessEvent logoutSuccessEvent = new OnUserLogoutSuccessEvent(currentUser.getUsername(), logOutRequest.getToken());
        applicationEventPublisher.publishEvent(logoutSuccessEvent);
        String response = currentUser.getUsername() + " has successfully logged out from the system!";
        return ResponseEntity.ok(new ApiResponse<String>("success",LocalDateTime.now(), response));
    }

}
