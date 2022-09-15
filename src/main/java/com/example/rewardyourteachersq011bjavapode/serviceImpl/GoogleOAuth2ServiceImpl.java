package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.config.Security.JwtUtil;
import com.example.rewardyourteachersq011bjavapode.dto.GoogleOAuth2UserDto;
import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;
import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.response.TeacherRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class GoogleOAuth2ServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final ResponseService responder;

    @Override
    public ResponseEntity<ApiResponse> OAuth2Authenticate(GoogleOAuth2UserDto principal) {
        User existingUser = userRepository.findUserByEmail(principal.getEmail()).orElse(null);
        if (existingUser == null) {
            String name = principal.getFirstName() + " " + principal.getLastName();
            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(principal.getEmail());
            userRepository.save(newUser);
        }
        String token = "Bearer " + jwtUtil.generateToken(principal.getEmail());
        return responder.response(new ApiResponse<String>("success" , LocalDateTime.now() , token) , HttpStatus.OK);
    }

    @Override
    public UserRegistrationResponse registerUser(UserDto userDto) {
        return null;
    }

    @Override
    public TeacherRegistrationResponse registerTeacher(TeacherDto teacherDto, MultipartFile teacherId) throws IOException {
        return null;
    }
}

