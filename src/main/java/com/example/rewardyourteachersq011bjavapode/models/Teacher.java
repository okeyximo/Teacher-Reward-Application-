package com.example.rewardyourteachersq011bjavapode.models;


import com.example.rewardyourteachersq011bjavapode.enums.Status;
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
@DiscriminatorValue(value = "teacher")
public class Teacher extends User{

    private String teachingPeriod;
    @Enumerated(EnumType.STRING)
    private Status status;



}
