package com.example.rewardyourteachersq011bjavapode.dto;

import com.example.rewardyourteachersq011bjavapode.enums.SchoolType;
import com.example.rewardyourteachersq011bjavapode.enums.Status;
import com.example.rewardyourteachersq011bjavapode.models.School;
import com.example.rewardyourteachersq011bjavapode.models.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class TeacherDto {
    private String name;
    private String email;
    private String password;
    private String school;
    private String teachingPeriod;
    private List<Subject> subjectList;
    private SchoolType schoolType;

}
