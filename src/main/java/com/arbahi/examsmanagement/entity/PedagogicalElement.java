package com.arbahi.examsmanagement.entity;

import com.arbahi.examsmanagement.enums.Level;
import com.arbahi.examsmanagement.enums.PedElemType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedagogical_element")
@Getter
@Setter
public class PedagogicalElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Level level; // cp1 , cp2 , info , BigData

    @Enumerated(EnumType.STRING)
    private PedElemType type; // Element , module

    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private User coordinator;


}
