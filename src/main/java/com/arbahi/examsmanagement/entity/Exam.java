package com.arbahi.examsmanagement.entity;

import com.arbahi.examsmanagement.enums.ExamType;
import com.arbahi.examsmanagement.enums.Semester;
import com.arbahi.examsmanagement.enums.Session;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Semester semester;

    @Enumerated(EnumType.STRING)
    private Session session;

    @Enumerated(EnumType.STRING)
    private ExamType type;

    private LocalDateTime date;
    private LocalDateTime startTime;

    private int plannedDuration;
    @Column(nullable = false)
    private int actualDuration;

    @ManyToMany
    @JoinTable(
            name = "exam_rooms",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms;

    @ManyToMany
    @JoinTable(
            name = "exam_invigilators",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> invigilators;

    @ManyToMany
    @JoinTable(
            name = "exam_absence_controllers",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> absenceControllers;

    @ManyToMany
    @JoinTable(
            name = "exam_coordinators",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> coordinators;  // Coordinators (default is the course coordinator)

    private int academicYear;

    private String report;  // Textual report (defaults to "Nothing to report")

//    @Lob
//    private byte[] examPaper;  // File containing a copy of the exam paper
//
//    @Lob
//    private byte[] examReport;  // File containing a copy of the exam report


    public Exam() {
        this.report = "Nothing to report";
        this.actualDuration = this.plannedDuration;
    }
}
