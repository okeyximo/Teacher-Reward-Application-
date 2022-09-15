package com.example.rewardyourteachersq011bjavapode.response;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TeacherRegistrationResponse {
    private String message;
    private LocalDateTime timeStamp;
    private TeacherDto teacherDto;
}
