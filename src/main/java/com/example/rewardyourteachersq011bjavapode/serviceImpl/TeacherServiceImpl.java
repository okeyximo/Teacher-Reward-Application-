package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.repository.TeacherRepository;
import com.example.rewardyourteachersq011bjavapode.service.ITeacherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Page<TeacherDetails> getAllTeachersWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<TeacherDetails> teacherDetailsList = teacherRepository.findAll(pageable).stream().map(teacher -> new TeacherDetails(teacher.getName(), teacher.getSchool(), teacher.getTeachingPeriod())).collect(Collectors.toList());
        return new PageImpl<>(teacherDetailsList, pageable, teacherDetailsList.size());
    }
}