package com.example.rewardyourteachersq011bjavapode.repository;

import com.example.rewardyourteachersq011bjavapode.models.Transaction;
import com.example.rewardyourteachersq011bjavapode.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
