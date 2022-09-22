package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITeacherService {
    Page<TeacherDetails> getAllTeacherBySchoolWithPagination(int pageNo, int pageSize, String schoolName);
}
