package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.models.Transaction;
import com.example.rewardyourteachersq011bjavapode.models.Wallet;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public ApiResponse<List<Transaction>> findAllTransactionForAUser(Long user_id);

}
