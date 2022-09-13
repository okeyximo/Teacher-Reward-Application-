package com.example.rewardyourteachersq011bjavapode.models;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("student")
public class Student extends User{



}
