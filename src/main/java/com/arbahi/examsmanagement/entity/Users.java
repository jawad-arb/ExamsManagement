package com.arbahi.examsmanagement.entity;

import com.arbahi.examsmanagement.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType type; // admin , teacher
    @ManyToMany(mappedBy = "teachers")
    private List<TeacherGroup> groups;

}

