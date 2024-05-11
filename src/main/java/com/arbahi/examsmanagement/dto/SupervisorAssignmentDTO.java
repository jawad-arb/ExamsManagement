package com.arbahi.examsmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupervisorAssignmentDTO {
    private Integer id;

    private Integer examId;

    private Integer roomId;

    private Integer invigilatorId;
}
