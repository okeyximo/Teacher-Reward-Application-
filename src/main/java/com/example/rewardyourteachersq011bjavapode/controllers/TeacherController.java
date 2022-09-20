package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.models.Teacher;
import com.example.rewardyourteachersq011bjavapode.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TeacherController {
   private final TeacherService teacherService;

    @GetMapping("getAllTeachers")
    public List<TeacherDetails> getAllTeachers() {

        return teacherService.getAllTeachers();
    }

    @GetMapping("getAllWithPagination")
    public List<TeacherDetails> getAllTeachersWithPagination (@RequestParam int pageNo,
                                                               @RequestParam int pageSize) {

        List<Teacher> teacherList = teacherService.
                getAllTeachersWithPagination(pageNo, pageSize);

        List<TeacherDetails> teacherResponseList = new ArrayList<>();

        teacherList.forEach(teacher -> {
            teacherResponseList.add(new TeacherDetails(teacher.getName(), teacher.getSchool(), teacher.getTeachingPeriod()));
        });

        return teacherResponseList;
    }


}
