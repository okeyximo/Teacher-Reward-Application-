package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.enums.SocialRegLogProvider;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.repository.UserRepository;
import com.example.rewardyourteachersq011bjavapode.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public String processSocialRegistration(String email) {


            User newUser = new User();
            newUser.setEmail(email);
            newUser.setSocialRegLogProvider(SocialRegLogProvider.GOOGLE);
            userRepository.save(newUser);

        return "User Successfully Registered";
    }
}
