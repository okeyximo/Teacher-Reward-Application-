package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;
import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.response.TeacherRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    UserRegistrationResponse registerUser(UserDto userDto);
    TeacherRegistrationResponse registerTeacher(TeacherDto teacherDto, MultipartFile teacherId) throws IOException;

}
