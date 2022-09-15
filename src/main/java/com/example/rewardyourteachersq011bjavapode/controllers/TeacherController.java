package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;
import com.example.rewardyourteachersq011bjavapode.response.TeacherRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;
@RestController
@Slf4j
public class TeacherController {
    private final UserService userService;
    @Autowired
    public TeacherController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register-teacher")
    public ResponseEntity<TeacherRegistrationResponse> registerTeacher(TeacherDto teacherDto, @RequestPart MultipartFile teacherIdImage) throws IOException {
        log.info("Successfully Registered {} ", teacherDto.getEmail());
        return new ResponseEntity<>(userService.registerTeacher(teacherDto, teacherIdImage), CREATED);
    }
}
