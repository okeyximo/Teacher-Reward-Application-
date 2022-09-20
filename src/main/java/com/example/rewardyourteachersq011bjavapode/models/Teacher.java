package com.example.rewardyourteachersq011bjavapode.models;


import com.example.rewardyourteachersq011bjavapode.enums.SchoolType;
import com.example.rewardyourteachersq011bjavapode.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;


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

    @Enumerated(EnumType.STRING)
    private SchoolType schoolType;



    private  String teacherIdUrl;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subject;


}
