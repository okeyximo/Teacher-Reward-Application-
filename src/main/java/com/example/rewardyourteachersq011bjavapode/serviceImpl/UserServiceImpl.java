package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.enums.NotificationType;
import com.example.rewardyourteachersq011bjavapode.event.OnUserLogoutSuccessEvent;
import com.example.rewardyourteachersq011bjavapode.exceptions.UserNotFoundException;
import com.example.rewardyourteachersq011bjavapode.exceptions.WalletNotFoundException;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.models.Wallet;
import com.example.rewardyourteachersq011bjavapode.repository.SubjectRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.repository.WalletRepository;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.service.NotificationService;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.rewardyourteachersq011bjavapode.enums.NotificationType.CREDIT_NOTIFICATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    public ApiResponse<String> logoutUser(CustomUserDetails currentUser, String bearerToken) {
        String token = bearerToken.substring(7);
        OnUserLogoutSuccessEvent logoutSuccessEvent = new OnUserLogoutSuccessEvent(currentUser.getUsername(), token);
        applicationEventPublisher.publishEvent(logoutSuccessEvent);
        String response = currentUser.getUsername() + " has successfully logged out from the system!";
        return new ApiResponse<>("success", LocalDateTime.now(), response);
    }

    @Override
    @Transactional
    public ApiResponse<String> fundWallet(CustomUserDetails currentUserDetails, BigDecimal amount) {
        User currentUser = userRepository.findUserByEmail(currentUserDetails.getUsername()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Optional<Wallet> optionalWallet = walletRepository.findWalletByUser(currentUser);
        Wallet wallet;
        if (optionalWallet.isEmpty()) {
            wallet = new Wallet(amount, currentUser);
        } else {
            wallet = optionalWallet.get();
            wallet.setBalance(wallet.getBalance().add(amount));
        }
        walletRepository.save(wallet);
        String response = "Credit!, Amt: %s; Wallet Balance: %s".formatted(amount.toString(), wallet.getBalance().toString());
         log.info("%s successfully deposited %s to his wallet".formatted(currentUser.getName(), amount));
        notificationService.saveNotification(currentUser.getId(), response, CREDIT_NOTIFICATION);
        return new ApiResponse<>("success", LocalDateTime.now(), response);
    }


}
