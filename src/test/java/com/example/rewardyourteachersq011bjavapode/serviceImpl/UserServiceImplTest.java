package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.enums.NotificationType;
import com.example.rewardyourteachersq011bjavapode.enums.Role;
import com.example.rewardyourteachersq011bjavapode.enums.SchoolType;
import com.example.rewardyourteachersq011bjavapode.enums.Status;
import com.example.rewardyourteachersq011bjavapode.models.*;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Calendar.SEPTEMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    private LocalDateTime localDateTime;

    private User user;
    private Teacher teacher;
//    private BaseClass baseClass;

    private List<Subject> subjectList;
    private List<Transaction> transactionList;
    private List<Message> messageList;
    private List<Notification> notificationList;
    private UserRegistrationResponse userRegistrationResponse;

    private School school;
    private Transaction transaction;
    private Subject subject;
    private Notification notification;
    private Message message;
    private List<User> userList;
    private MultipartFile teacherId;



    @BeforeEach
    void setUp() {
        localDateTime = LocalDateTime.of(2022, SEPTEMBER,14,6,30,40,50000);
        user = new User(1L , localDateTime , localDateTime , "chioma", Role.STUDENT,"chioma@gmail.com","1234",transactionList, messageList, notificationList, "school");
        teacher = new Teacher("20", Status.INSERVICE, SchoolType.SECONDARY,"oxy.png",subjectList);
        message = new Message("new message", user);
        notification = new Notification("alertz", NotificationType.CREDIT_NOTIFICATION ,user);
        subject = new Subject("Economics" , teacher);
    }

//    @Test
//    void registerUser() {
//        UserDto userDto = new UserDto("chioma","chioma@gmail.com","1234","school");
//        when(userRepository.save(user)).thenReturn(user);
//        var actual = userService.registerUser(userDto);
//        userRegistrationResponse = new UserRegistrationResponse("success",localDateTime, userDto);
//        assertEquals(userRegistrationResponse.getUserDto().getName() , actual.getUserDto().getName());
//        assertEquals(userRegistrationResponse.getUserDto().getEmail() , actual.getUserDto().getEmail());
//        assertEquals(userRegistrationResponse.getUserDto().getPassword() , actual.getUserDto().getPassword());
//        assertEquals(userRegistrationResponse.getUserDto().getSchool() , actual.getUserDto().getSchool());
//
//    }

//    @Test
//    void registerTeacher() {
//        TeacherRegistrationDto teacherDto = new TeacherRegistrationDto("vincent","vincent@gmail.com","12345","school","20", subjectList,SchoolType.SECONDARY);\
//        when(userRepository.save(teacher)).thenReturn(teacher);
//        var actual = userService.registerTeacher(teacherDto,);
//        teacherRegistrationResponse = new TeacherRegistrationResponse("success",localDateTime, teacherDto);
//        assertEquals(teacherRegistrationResponse.getTeacherDto().getName() , actual.getTeacherDto().getName());
//        assertEquals(teacherRegistrationResponse.getTeacherDto().getEmail() , actual.getTeacherDto().getEmail());
//        assertEquals(teacherRegistrationResponse.getTeacherDto().getPassword() , actual.getTeacherDto().getPassword());
//        assertEquals(teacherRegistrationResponse.getTeacherDto().getSchool() , actual.getTeacherDto().getSchool());
//        assertEquals(teacherRegistrationResponse.getTeacherDto().getTeachingPeriod() , actual.getTeacherDto().getTeachingPeriod());
//        assertEquals(teacherRegistrationResponse.getTeacherDto().getSubjectList() , actual.getTeacherDto().getSubjectList());
//        assertEquals(teacherRegistrationResponse.getTeacherDto().getSchoolType() , actual.getTeacherDto().getSchoolType());


//    }


}