package com.example.rewardyourteachersq011bjavapode.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class InitializeTransactionRequest {

    @Digits(integer = 9, fraction = 0)
    private String amount;
    private String email;

}
