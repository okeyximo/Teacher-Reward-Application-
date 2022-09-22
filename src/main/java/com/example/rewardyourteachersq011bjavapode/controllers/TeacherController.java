package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.models.Teacher;
import com.example.rewardyourteachersq011bjavapode.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TeacherController {
    private final ITeacherService teacherService;


    @GetMapping("getAllWithPagination")
    public Page<TeacherDetails> getAllTeachersWithPagination(@RequestParam int pageNo,
                                                             @RequestParam int pageSize) {

        return teacherService.getAllTeachersWithPagination(pageNo, pageSize);
    }






}
