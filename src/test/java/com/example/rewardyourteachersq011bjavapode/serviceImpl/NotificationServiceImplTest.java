package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.enums.NotificationType;
import com.example.rewardyourteachersq011bjavapode.enums.Role;
import com.example.rewardyourteachersq011bjavapode.models.*;
import com.example.rewardyourteachersq011bjavapode.repository.NotificationRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class NotificationServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private NotificationRepository notificationRepository;

    private Notification notification;
    private User user;
    private School school;
    private NotificationServiceImpl notificationService;

    List<Transaction> transactionList = new ArrayList<>();
    List<Message> messageList = new ArrayList<>();
    List<Notification> notificationList = new ArrayList<>();




    @BeforeEach
    void setUp() {
        user = new User("Oluwaseun","Fredrick", Role.STUDENT,"oluwaseun@gmail.com","students",transactionList,messageList,notificationList, school);
        notification = new Notification("Your wallet has been credited",NotificationType.CREDIT_NOTIFICATION, user);

    }

    @Test
    void saveNotification() {
     when(userRepository.findById(user.getId()));
     Notification notification1 = notification;
     notificationService = new NotificationServiceImpl(notificationRepository,userRepository);
     notificationService.saveNotification(1L,"Your wallet has been credited",NotificationType.CREDIT_NOTIFICATION);
     var actual = notificationService;
     assertEquals(notification1, actual);
    }

    @Test
    void findUserById() {
    }
}