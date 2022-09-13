package com.example.rewardyourteachersq011bjavapode.repository;

import com.example.rewardyourteacher.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, Long> {
}
