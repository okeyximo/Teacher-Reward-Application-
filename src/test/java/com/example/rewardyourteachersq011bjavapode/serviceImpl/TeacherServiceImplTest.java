package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TeacherServiceImplTest {
    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @Test
    void testGetAllTeachersWithPagination() {

        assertTrue(teacherServiceImpl.getAllTeachersWithPagination(1, 3).isEmpty());
        assertTrue(teacherServiceImpl.getAllTeachersWithPagination(0, 3).isEmpty());
    }


}

