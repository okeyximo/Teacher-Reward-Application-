package com.example.rewardyourteachersq011bjavapode.repository;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.models.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        TeacherDetails teacherDetails = TeacherDetails.builder()
                .name("Bennett Yibawenifiri")
                .school("Lagos Grammar School")
                .teachingPeriod("2020 t0 2022")
                .build();
        entityManager.persist(teacherDetails);
    }

    @Test
    @Disabled
    void findAllBySchool() {
        Teacher teacher = teacherRepository.findById(1L).get();
        assertEquals(teacher.getName(), "Bennett Yibawenifiri");
    }
}