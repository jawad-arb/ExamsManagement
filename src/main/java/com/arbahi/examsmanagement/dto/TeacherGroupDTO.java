package com.arbahi.examsmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class TeacherGroupDTO {

    private Integer groupId;
    private String name;
    private String description;
    private List<Integer> teacherIds;

}
