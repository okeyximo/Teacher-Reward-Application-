package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;
import com.example.rewardyourteachersq011bjavapode.response.TeacherRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@Api
public class TeacherController {


}
