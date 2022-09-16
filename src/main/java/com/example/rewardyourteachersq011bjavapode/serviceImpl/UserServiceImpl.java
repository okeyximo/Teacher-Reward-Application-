package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.dto.TeacherDto;
import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.exceptions.UserAlreadyExistException;
import com.example.rewardyourteachersq011bjavapode.models.School;
import com.example.rewardyourteachersq011bjavapode.models.Subject;
import com.example.rewardyourteachersq011bjavapode.models.Teacher;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.repository.SubjectRepository;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.response.TeacherRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;


     private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;



    @Override
    public UserRegistrationResponse registerUser(UserDto userDto) {
        String email = userDto.getEmail();
        Optional<User> existingUser = userRepository.findUserByEmail(email);
        if(existingUser.isEmpty()){
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setSchool(userDto.getSchool());
            userRepository.save(user);
            return new UserRegistrationResponse("success", LocalDateTime.now(),userDto);
        }else {
            throw new UserAlreadyExistException("User already exist");
        }

    }

    @Override
    public TeacherRegistrationResponse registerTeacher(TeacherDto teacherDto, MultipartFile teacherId) throws IOException {
        String email = teacherDto.getEmail();
        Optional<User> existingUser = userRepository.findUserByEmail(email);

        if(existingUser.isEmpty()){
            Teacher teacher = new Teacher();
            teacher.setName(teacherDto.getName());
            teacher.setEmail(teacherDto.getEmail());
            teacher.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
            teacher.setSchool(teacherDto.getSchool());
            teacher.setTeachingPeriod(teacherDto.getTeachingPeriod());
            teacher.setSchoolType(teacherDto.getSchoolType());
            teacher.setTeacherIdUrl(userUtil.uploadImage(teacherId));
            userRepository.save(teacher);


            teacherDto.getSubjectList().forEach(subject -> {
                subjectRepository.save(new Subject(subject , teacher));
            });

            return new TeacherRegistrationResponse("success", LocalDateTime.now(),teacherDto);
        }else{
            throw new UserAlreadyExistException("User already exist");
        }

        //["English" , "Maths" , "Biology"]

       // new Subject("english" , teacher); //3


    }
}
