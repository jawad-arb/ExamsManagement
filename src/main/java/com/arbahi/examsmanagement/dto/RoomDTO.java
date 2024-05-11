package com.arbahi.examsmanagement.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {
    private Integer id;
    private String name;
    private int capacity;
    private List<Integer> examsId;
    private List<Integer> invigilatorAssignmentsId;
    private List<Integer> absenceControllerAssignmentsId;
}
