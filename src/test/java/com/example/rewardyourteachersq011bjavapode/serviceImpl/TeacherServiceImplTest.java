package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TeacherServiceImplTest {
    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @Test
    void testGetAllTeachersWithPagination() {
        // Arrange, Act and Assert
        assertTrue(teacherServiceImpl.getAllTeachersWithPagination(1, 3).isEmpty());
        assertTrue(teacherServiceImpl.getAllTeachersWithPagination(0, 3).isEmpty());
    }


}

