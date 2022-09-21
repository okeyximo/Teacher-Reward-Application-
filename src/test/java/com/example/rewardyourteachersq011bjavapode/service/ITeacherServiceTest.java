package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.repository.TeacherRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ITeacherServiceTest {

    @Autowired
    private ITeacherService iTeacherService;

    @MockBean
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void retrievingAllTeachersIn_A_ParticularSchool() {
        int pageNo = 1;
        int pageSize = 5;
        String schoolName = "Lagos Grammer School";
        iTeacherService.getAllTeacherBySchoolWithPagination(pageNo, pageSize, schoolName);
        assertEquals(pageNo, pageSize);

    }
}