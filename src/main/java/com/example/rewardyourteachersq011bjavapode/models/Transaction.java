package com.example.rewardyourteachersq011bjavapode.models;
import com.example.rewardyourteachersq011bjavapode.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction extends BaseClass{
    private Long uuid;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId" , referencedColumnName = "id")
    private User user;



}

