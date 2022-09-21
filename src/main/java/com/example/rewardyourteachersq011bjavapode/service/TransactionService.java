package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.models.Transaction;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import java.util.List;

public interface TransactionService {
    ApiResponse<List<Transaction>> findAllTransactionForAUser(Long user_id);

}
