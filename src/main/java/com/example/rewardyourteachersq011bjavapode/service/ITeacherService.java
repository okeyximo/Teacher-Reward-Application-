package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;

import java.util.List;

public interface ITeacherService {
    List<TeacherDetails> getAllTeacherBySchoolWithPagination(int pageNo, int pageSize, String schoolName);
}
