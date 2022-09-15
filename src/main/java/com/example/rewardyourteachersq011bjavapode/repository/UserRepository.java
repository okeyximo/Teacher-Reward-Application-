package com.example.rewardyourteachersq011bjavapode.repository;


import com.example.rewardyourteachersq011bjavapode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
