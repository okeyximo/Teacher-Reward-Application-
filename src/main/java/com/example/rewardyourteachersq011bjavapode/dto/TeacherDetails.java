package com.example.rewardyourteachersq011bjavapode.dto;

import lombok.Builder;

@Builder
public record TeacherDetails(String name, String school, String teachingPeriod) {
}
