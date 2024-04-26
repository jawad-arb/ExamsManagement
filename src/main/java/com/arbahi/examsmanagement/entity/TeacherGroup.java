package com.arbahi.examsmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "teacher_group")
@Getter
@Setter
public class TeacherGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "teacher_group_members",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> teachers;

}
