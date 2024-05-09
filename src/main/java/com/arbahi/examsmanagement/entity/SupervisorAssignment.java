package com.arbahi.examsmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * invigilator assignment for the TEACHER
 */
@Entity
@Getter
@Setter
public class SupervisorAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;  // The exam to which this invigilator assignment belongs

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;  // The room in which the invigilator is assigned

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User invigilator;
}
