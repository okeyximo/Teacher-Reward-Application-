package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.InitializeTransactionRequest;
import com.example.rewardyourteachersq011bjavapode.response.InitializeTransactionResponse;
import com.example.rewardyourteachersq011bjavapode.response.VerifyTransactionResponse;
import com.example.rewardyourteachersq011bjavapode.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;


    @PostMapping("/make-payment")
    public ResponseEntity<?> pay(@RequestBody InitializeTransactionRequest request) throws Exception {
        return ResponseEntity.ok(paymentService.initTransaction(request));
    }

    @GetMapping("/verify-transaction")
    public ResponseEntity<VerifyTransactionResponse> verifyTransaction(String reference){
        return ResponseEntity.ok(paymentService.verifyTransaction(reference));
    }
}
