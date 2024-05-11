package com.arbahi.examsmanagement.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int capacity;
    @ManyToMany(mappedBy = "rooms")
    private Set<Exam> exams;
    @OneToMany(mappedBy = "room")
    private Set<SupervisorAssignment> invigilatorAssignments;

    @OneToMany(mappedBy = "room")
    private Set<AbsenceControllerAssignment> absenceControllerAssignments;
}