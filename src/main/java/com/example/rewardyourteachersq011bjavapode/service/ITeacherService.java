package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.models.Teacher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITeacherService {
    Page<TeacherDetails> getAllTeachersWithPagination(int pageNo, int pageSize);
}
