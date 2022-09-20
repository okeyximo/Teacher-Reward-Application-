package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.models.Teacher;
import com.example.rewardyourteachersq011bjavapode.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public List<TeacherDetails> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacher -> new TeacherDetails(teacher.getName(), teacher.getSchool(), teacher.getTeachingPeriod())).collect(Collectors.toList());
    }
    public List<Teacher> getAllTeachersWithPagination (int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return teacherRepository.findAll(pageable).getContent();
    }
}