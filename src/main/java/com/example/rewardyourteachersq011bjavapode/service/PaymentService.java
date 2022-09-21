package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.dto.InitializeTransactionRequest;
import com.example.rewardyourteachersq011bjavapode.response.InitializeTransactionResponse;

public interface PaymentService {

    InitializeTransactionResponse initTransaction(InitializeTransactionRequest request) throws Exception;
}
