package com.example.rewardyourteachersq011bjavapode.models;

import com.example.rewardyourteachersq011bjavapode.enums.Role;
import com.example.rewardyourteachersq011bjavapode.enums.SocialRegLogProvider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@Table(name = "users")
public class User  extends BaseClass implements Serializable{
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private SocialRegLogProvider socialRegLogProvider;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Message> messageList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Notification> notificationList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "schoolId" , referencedColumnName = "id")
    private School school;

    public User(Long id, LocalDateTime createDate, LocalDateTime updateDate, String firstName, String lastName, Role role, String email, String password, List<Transaction> transactionList, List<Message> messageList, List<Notification> notificationList, School school) {
        super(id, createDate, updateDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.password = password;
        this.transactionList = transactionList;
        this.messageList = messageList;
        this.notificationList = notificationList;
        this.school = school;
    }
}

