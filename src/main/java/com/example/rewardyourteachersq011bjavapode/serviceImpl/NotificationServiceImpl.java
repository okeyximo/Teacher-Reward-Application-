package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.dto.NotificationDto;
import com.example.rewardyourteachersq011bjavapode.enums.NotificationType;
import com.example.rewardyourteachersq011bjavapode.exceptions.UserNotFoundException;
import com.example.rewardyourteachersq011bjavapode.models.Notification;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.repository.NotificationRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.service.EmailService;
import com.example.rewardyourteachersq011bjavapode.service.NotificationService;

import com.example.rewardyourteachersq011bjavapode.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    private final EmailService emailService;


    @Override
    public Notification saveNotification(Long userId, String message, NotificationType notificationType) {
        Notification notification = new Notification();
        User user = findUserById(userId);
        notification.setNotificationBody(message);
        notification.setUser(user);
        notification.setNotificationType(notificationType);
        return notificationRepository.save(notification);
    }


    @Override
    public Notification saveNotification(String email, String message, NotificationType notificationType) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));

        boolean success = emailService.sendSimpleEmail(message, notificationType.toString(), email);
        if (success) {
            log.info("Email notification sent to %s".formatted(user.getName()));
        } else {
            log.error("Email notification not sent");
        }
        return notificationRepository.save(new Notification(message, notificationType, user));
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
    }

    @Override
    public List<NotificationDto> retrieveUserNotifications() {
        String userEmail = userUtil.getAuthenticatedUserEmail();
        return notificationRepository.findAllByUserEmail(userEmail)
                .stream()
                .map(n -> new NotificationDto(n.getNotificationBody(), n.getNotificationType()))
                .toList();
    }
}
