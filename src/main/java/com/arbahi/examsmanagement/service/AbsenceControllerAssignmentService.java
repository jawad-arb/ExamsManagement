package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;

import java.util.List;
import java.util.Optional;

public interface AbsenceControllerAssignmentService {
    List<AbsenceControllerAssignmentDTO> getAllAbsenceControllerAssignments();

    Optional<AbsenceControllerAssignmentDTO> getAbsenceControllerAssignmentById(Integer id);

    AbsenceControllerAssignmentDTO createAbsenceControllerAssignment(AbsenceControllerAssignmentDTO assignmentDTO) throws Exception;

    Optional<AbsenceControllerAssignmentDTO> updateAbsenceControllerAssignment(Integer id, AbsenceControllerAssignmentDTO updatedAssignmentDTO) throws Exception;

    boolean deleteAbsenceControllerAssignment(Integer id);

}

