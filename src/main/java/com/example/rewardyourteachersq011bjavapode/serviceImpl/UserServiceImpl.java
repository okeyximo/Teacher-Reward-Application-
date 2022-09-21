package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.dto.UserProfileDto;
import com.example.rewardyourteachersq011bjavapode.enums.Role;
import com.example.rewardyourteachersq011bjavapode.event.OnUserLogoutSuccessEvent;
import com.example.rewardyourteachersq011bjavapode.exceptions.UserNotFoundException;
import com.example.rewardyourteachersq011bjavapode.models.Teacher;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.repository.SubjectRepository;
import com.example.rewardyourteachersq011bjavapode.repository.TeacherRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;
    private final ApplicationEventPublisher applicationEventPublisher;


   @Override
   public ApiResponse<String> logoutUser(CustomUserDetails currentUser, String bearerToken){
        String token = bearerToken.substring(7);
        OnUserLogoutSuccessEvent logoutSuccessEvent = new OnUserLogoutSuccessEvent(currentUser.getUsername(), token);
        applicationEventPublisher.publishEvent(logoutSuccessEvent);
        String response = currentUser.getUsername() + " has successfully logged out from the system!";
        return new ApiResponse<>("success",LocalDateTime.now(), response);
    }


    @Override
    public ApiResponse<List<User>> searchTeacher(String name) {
        List<User> teacher = userRepository.findByRoleAndNameContainingIgnoreCase(Role.TEACHER , name);
        log.info("{}" , teacher);
        return  new ApiResponse<>("success", LocalDateTime.now() , teacher);
    }


    public User findById(Long id){
        User teacher = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));
        return  teacher;
    }

    @Override
    public ApiResponse<UserProfileDto> viewProfile(Long id) {
       UserProfileDto teacherProfile = new UserProfileDto() ;
       Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user id not found"));
       teacherProfile.setName(teacher.getName());
       teacherProfile.setSchool(teacher.getSchool());
       teacherProfile.setPost(teacher.getPost());
       teacherProfile.setAbout(teacher.getAbout());
       teacherProfile.setEmail(teacher.getEmail());
       teacherProfile.setTelephone(teacher.getTelephone());
        return new ApiResponse<>("success",LocalDateTime.now(),teacherProfile);

    }


}
