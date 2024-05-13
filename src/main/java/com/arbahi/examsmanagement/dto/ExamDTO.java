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
    private Integer id;
    private String semester;
    private String session;
    private String type;
    private LocalDateTime startTime;
    private int actualDuration;
    private List<UsersDTO> coordinators;
    private List<RoomDTO> rooms;
    private List<UsersDTO> invigilators; // List of IDs for the invigilators assigned to the exam
    private List<UsersDTO> absenceControllers; // List of IDs for the staff members assigned to control absences
}
