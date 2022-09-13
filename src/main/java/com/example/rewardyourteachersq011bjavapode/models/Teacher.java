package com.example.rewardyourteachersq011bjavapode.models;

import com.example.rewardyourteacher.enums.Status;
//import com.example.rewardyourteachersq011bjavapode.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher extends User{

    private String teachingPeriod;
    private Status status;

    public Teacher(Long id, String firstName, String lastName, String email, String password, LocalDateTime createdAt, LocalDateTime updateddAt, List<Transaction> transactionList, List<Message> messageList, List<Notification> notificationList, School school, String teachingPeriod, Status status) {
        super(id, firstName, lastName, email, password, createdAt, updateddAt, transactionList, messageList, notificationList, school);
        this.teachingPeriod = teachingPeriod;
        this.status = status;
    }
}
