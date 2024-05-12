package com.arbahi.examsmanagement.entity;

import jakarta.persistence.*;
import lombok.*;


/**
 * invigilator assignment for the ADMIN
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceControllerAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User absenceController;
}
