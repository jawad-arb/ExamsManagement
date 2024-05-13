package com.arbahi.examsmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupervisorAssignmentDTO {
    private Integer id;

    private ExamDTO exam;

    private RoomDTO room;

    private UsersDTO invigilator;
}
