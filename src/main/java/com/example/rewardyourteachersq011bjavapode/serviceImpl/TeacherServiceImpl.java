package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.repository.TeacherRepository;
import com.example.rewardyourteachersq011bjavapode.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherDetails> getAllTeacherBySchoolWithPagination(int pageNo, int pageSize, String schoolName) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return teacherRepository.findAllBySchool(schoolName, pageable).stream().map(teacher -> new TeacherDetails(teacher.getName(), teacher.getSchool(), teacher.getTeachingPeriod())).collect(Collectors.toList());
    }

}
