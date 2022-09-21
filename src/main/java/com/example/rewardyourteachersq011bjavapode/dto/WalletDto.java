package com.example.rewardyourteachersq011bjavapode.dto;

import com.example.rewardyourteachersq011bjavapode.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WalletDto {
    private int balance;
    private User user;
}
