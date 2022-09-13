package com.example.rewardyourteachersq011bjavapode.models;

import com.example.rewardyourteacher.enums.Type;
//import com.example.rewardyourteachersq011bjavapode.enums.Status;
//import com.example.rewardyourteachersq011bjavapode.enums.Type;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long uuid;
    private Type type;
    private String description;
    private LocalDateTime createdAt;




    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId" , referencedColumnName = "id")
    private User user;

}

