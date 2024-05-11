package com.arbahi.examsmanagement.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamDTO {
    private Integer examId;
    private String semester;
    private String session;
    private String type;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private Integer plannedDuration;
    private Integer actualDuration;
    private Integer coordinatorId;
    private List<Integer> roomIds;
    private List<Integer> invigilatorIds; // List of IDs for the invigilators assigned to the exam
    private List<Integer> absenceControllerIds; // List of IDs for the staff members assigned to control absences
    private String academicYear; // Academic year of the exam
}
