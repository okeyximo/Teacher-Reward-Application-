package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class TeacherController {

    private final ITeacherService teacherService;

    @GetMapping("/getAllWithPagination/{pageNo}/{pageSize}/{schoolName}")
    public Page<TeacherDetails> getAllTeachersBySchoolWithPagination(@PathVariable("pageNo") int pageNo,
                                                                     @PathVariable("pageSize") int pageSize,
                                                                     @PathVariable("schoolName") String schoolName) {
        return teacherService.getAllTeacherBySchoolWithPagination(pageNo, pageSize, schoolName);
    }


}
