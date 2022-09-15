package com.example.rewardyourteachersq011bjavapode.repository;


import com.example.rewardyourteachersq011bjavapode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
=======

>>>>>>> 590f370657339e7706290c7a726df0b5bb477140
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;
<<<<<<< HEAD

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String username);



=======
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
>>>>>>> 590f370657339e7706290c7a726df0b5bb477140
}
