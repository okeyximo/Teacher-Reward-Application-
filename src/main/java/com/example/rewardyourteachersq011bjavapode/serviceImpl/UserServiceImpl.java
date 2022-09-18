package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.event.OnUserLogoutSuccessEvent;
import com.example.rewardyourteachersq011bjavapode.repository.SubjectRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;
    private final ApplicationEventPublisher applicationEventPublisher;


   @Override
   public ApiResponse<String> logoutUser(CustomUserDetails currentUser, String bearerToken){
        String token = bearerToken.substring(7);
        OnUserLogoutSuccessEvent logoutSuccessEvent = new OnUserLogoutSuccessEvent(currentUser.getUsername(), token);
        applicationEventPublisher.publishEvent(logoutSuccessEvent);
        String response = currentUser.getUsername() + " has successfully logged out from the system!";
        return new ApiResponse<>("success",LocalDateTime.now(), response);
    }



}
