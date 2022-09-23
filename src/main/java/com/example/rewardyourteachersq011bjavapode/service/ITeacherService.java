package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import org.springframework.data.domain.Page;


public interface ITeacherService {
    Page<TeacherDetails> getAllTeacherBySchoolWithPagination(int pageNo, int pageSize, String schoolName);

    Page<TeacherDetails> getAllTeachersWithPagination(int pageNo, int pageSize);
}
