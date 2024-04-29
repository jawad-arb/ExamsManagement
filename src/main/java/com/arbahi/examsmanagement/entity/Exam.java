package com.arbahi.examsmanagement.entity;

import com.arbahi.examsmanagement.enums.ExamType;
import com.arbahi.examsmanagement.enums.Semester;
import com.arbahi.examsmanagement.enums.Session;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Semester semester;  // Spring, Autumn (default value inferred from system date)

    @Enumerated(EnumType.STRING)
    private Session session;  // Normal, Resit (default value is normal)

    @Enumerated(EnumType.STRING)
    private ExamType type;  // Exam type (e.g., Supervised Exam 1, Supervised Exam 2) from a list

    private LocalDate date;
    private LocalTime startTime;

    private int plannedDuration;  // Planned duration (e.g., 90 minutes)
    private int actualDuration;  // Actual duration after exams (defaults to plannedDuration if not set)

    @ManyToMany
    @JoinTable(
            name = "exam_rooms",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms;  // Exam rooms

    @ManyToMany
    @JoinTable(
            name = "exam_invigilators",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> invigilators;  // Invigilators for each room

    @ManyToMany
    @JoinTable(
            name = "exam_absence_controllers",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> absenceControllers;  // Absence controllers for each room

    @ManyToMany
    @JoinTable(
            name = "exam_coordinators",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> coordinators;  // Coordinators (default is the course coordinator)

    private int academicYear;

    private String report;  // Textual report (defaults to "Nothing to report")

    @Lob
    private byte[] examPaper;  // File containing a copy of the exam paper

    @Lob
    private byte[] examReport;  // File containing a copy of the exam report


    public Exam() {
        this.report = "Nothing to report";
        this.actualDuration = this.plannedDuration;
    }
}
