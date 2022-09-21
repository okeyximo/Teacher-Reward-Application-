package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.dto.UserProfileDto;
import com.example.rewardyourteachersq011bjavapode.enums.NotificationType;
import com.example.rewardyourteachersq011bjavapode.enums.Role;
import com.example.rewardyourteachersq011bjavapode.enums.SchoolType;
import com.example.rewardyourteachersq011bjavapode.enums.Status;
import com.example.rewardyourteachersq011bjavapode.models.*;
import com.example.rewardyourteachersq011bjavapode.repository.TeacherRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Calendar.SEPTEMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    TeacherRepository teacherRepository;


    private LocalDateTime localDateTime;

    private User user;
    private Teacher teacher;


    private List<Subject> subjectList;
    private List<Transaction> transactionList;
    private List<Message> messageList;
    private List<Notification> notificationList;
    private UserRegistrationResponse userRegistrationResponse;
    private ApiResponse response;

    private School school;
    private Transaction transaction;
    private Subject subject;
    private Notification notification;
    private Message message;
    private List<User> userList;
    private MultipartFile teacherId;



    @BeforeEach
    void setUp() {
        localDateTime = LocalDateTime.now();
        user = new User(1L , localDateTime , localDateTime , "chioma", Role.TEACHER,"chioma@gmail.com","1234","","",transactionList, messageList, notificationList, "school");
        teacher = new Teacher( "chioma",Role.TEACHER,"chioma@gmail.com","1234", "","",transactionList, messageList, notificationList, "school","20", Status.INSERVICE,"", SchoolType.SECONDARY,"oxy.png",subjectList);
        message = new Message("success", user);
        notification = new Notification("alertz", NotificationType.CREDIT_NOTIFICATION ,user);
        subject = new Subject("Economics" , teacher);
        when(userRepository.save(user)).thenReturn(user);
    }

    @Test
    void searchTeacher() {
        when(userRepository.findByRoleAndNameContainingIgnoreCase(Role.TEACHER, "chioma")).thenReturn(userList);
        var actual = userService.searchTeacher("chioma");
        actual.setTimeStamp(localDateTime);
        response = new ApiResponse<>("success", localDateTime, userList);
        assertEquals(response,actual);

    }

    @Test
    void viewProfile() {
        UserProfileDto profileDto = new UserProfileDto("","chioma","school","chioma@gmail.com","","");
        when(teacherRepository.findById(1L)).thenReturn(Optional.ofNullable(teacher));
        var actual = userService.viewProfile(1L);
        actual.setTimeStamp(localDateTime);
         response = new ApiResponse("success", localDateTime,profileDto);
       assertEquals(response, actual);

    }




}