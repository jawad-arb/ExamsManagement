package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;

import java.util.List;
import java.util.Optional;

public interface AbsenceControllerAssignmentService {
    List<AbsenceControllerAssignmentDTO> getAllAbsenceControllerAssignments();

    Optional<AbsenceControllerAssignmentDTO> getAbsenceControllerAssignmentById(Integer id);

    AbsenceControllerAssignmentDTO createAbsenceControllerAssignment(AbsenceControllerAssignmentDTO assignmentDTO);

    Optional<AbsenceControllerAssignmentDTO> updateAbsenceControllerAssignment(Integer id, AbsenceControllerAssignmentDTO updatedAssignmentDTO);

    boolean deleteAbsenceControllerAssignment(Integer id);

}

