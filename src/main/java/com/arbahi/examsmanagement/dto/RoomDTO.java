package com.arbahi.examsmanagement.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {
    private Integer id;
    private String name;
    private int capacity;
    private Set<ExamDTO> exams;
    private Set<SupervisorAssignmentDTO> invigilatorAssignments;
    private Set<AbsenceControllerAssignmentDTO> absenceControllerAssignments;
}
