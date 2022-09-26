package com.example.rewardyourteachersq011bjavapode.repository;

import com.example.rewardyourteachersq011bjavapode.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message , Long> {
    Optional<Message> findAllByUser_id(Long user_id);
}
