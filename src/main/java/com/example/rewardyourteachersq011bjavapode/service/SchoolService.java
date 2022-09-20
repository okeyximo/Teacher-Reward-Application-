package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.models.School;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;

import java.util.List;

public interface SchoolService {
    void addSchool(String csvPath);
    ApiResponse<List<School>> getAllSchools();
}
