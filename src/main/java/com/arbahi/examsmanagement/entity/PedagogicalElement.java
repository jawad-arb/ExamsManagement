package com.arbahi.examsmanagement.entity;

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
    private String level; // cp1 , cp2 , info , BigData
    private String type; // Element , module

    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Users coordinator;


}
