package com.arbahi.examsmanagement.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedagogicalElementDTO {
    private Integer id;
    private String title;
    private String level;
    private String type;
    private UsersDTO coordinator;
}
