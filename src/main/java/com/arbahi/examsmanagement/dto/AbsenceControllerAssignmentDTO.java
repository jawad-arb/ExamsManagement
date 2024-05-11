package com.arbahi.examsmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbsenceControllerAssignmentDTO {
    private Integer id;
    private Integer examId;
    private Integer roomId;
    private Integer absenceControllerId;
}
