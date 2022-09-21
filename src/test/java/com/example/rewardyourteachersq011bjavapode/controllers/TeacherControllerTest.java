package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.enums.Role;
import com.example.rewardyourteachersq011bjavapode.models.*;
import com.example.rewardyourteachersq011bjavapode.repository.TeacherRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherControllerTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    UserService userService;
    private User user;
    private Teacher teacher;
    List<Transaction> transactionList;
    List<Message> messageList;
    List<Notification> notificationList;



    @BeforeEach
    void setUp() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.SEPTEMBER, 20,4,12);
        user = new User(1l,localDateTime,localDateTime,"oluwaseun", Role.TEACHER,"oluwaseun@gmail.com","oluwaseun","","",transactionList,messageList,notificationList,"school");
    }

    @Test
    void searchTeacher() {

    }

    @Test
    void viewTeacherProfile() {
    }
}