package com.arbahi.examsmanagement.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int capacity;
    @ManyToMany(mappedBy = "rooms")
    private Set<Exam> exams;
    @OneToMany(mappedBy = "room")
    private Set<InvigilatorAssignment> invigilatorAssignments;

    @OneToMany(mappedBy = "room")
    private Set<AbsenceControllerAssignment> absenceControllerAssignments;
}