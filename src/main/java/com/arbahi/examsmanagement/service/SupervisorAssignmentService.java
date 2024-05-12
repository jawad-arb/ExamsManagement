package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.dto.SupervisorAssignmentDTO;

import java.util.List;
import java.util.Optional;

public interface SupervisorAssignmentService {
    List<SupervisorAssignmentDTO> getAllSupervisorAssignments();

    Optional<SupervisorAssignmentDTO> getSupervisorAssignmentById(Integer id);

    SupervisorAssignmentDTO createSupervisorAssignment(SupervisorAssignmentDTO assignmentDTO) throws Exception;

    Optional<SupervisorAssignmentDTO> updateSupervisorAssignment(Integer id, SupervisorAssignmentDTO updatedAssignmentDTO);

    boolean deleteSupervisorAssignment(Integer id);
}
