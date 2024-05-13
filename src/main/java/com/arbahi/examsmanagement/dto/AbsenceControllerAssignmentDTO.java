package com.arbahi.examsmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbsenceControllerAssignmentDTO {
    private Integer id;
    private ExamDTO exam;
    private RoomDTO room;
    private UsersDTO absenceController;
}
