package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.config.Security.CustomUserDetails;
import com.example.rewardyourteachersq011bjavapode.dto.FundWalletDto;
import com.example.rewardyourteachersq011bjavapode.service.CurrentUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.HttpStatus.OK;

public class PaymentController {


    @PutMapping("/confirm-payment")
    public ResponseEntity<?> confirmPaymentAndFundWallet(@CurrentUser CustomUserDetails customUserDetails, @RequestBody FundWalletDto fundWalletDto) {


        return new ResponseEntity<>(userService.fundWallet(customUserDetails, fundWalletDto.amount()), OK);
    }
}
