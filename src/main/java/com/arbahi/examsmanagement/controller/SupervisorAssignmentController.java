package com.arbahi.examsmanagement.controller;

import com.arbahi.examsmanagement.dto.SupervisorAssignmentDTO;
import com.arbahi.examsmanagement.service.SupervisorAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supervisor-assignments")
@RequiredArgsConstructor
public class SupervisorAssignmentController {

    private final SupervisorAssignmentService supervisorAssignmentService;

    @GetMapping
    public ResponseEntity<List<SupervisorAssignmentDTO>> getAllSupervisorAssignments() {
        List<SupervisorAssignmentDTO> assignments = supervisorAssignmentService.getAllSupervisorAssignments();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupervisorAssignmentDTO> getSupervisorAssignmentById(@PathVariable Integer id) {
        Optional<SupervisorAssignmentDTO> assignment = supervisorAssignmentService.getSupervisorAssignmentById(id);
        return assignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SupervisorAssignmentDTO> createSupervisorAssignment(@RequestBody SupervisorAssignmentDTO assignmentDTO) throws Exception {
        SupervisorAssignmentDTO createdAssignment = supervisorAssignmentService.createSupervisorAssignment(assignmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupervisorAssignmentDTO> updateSupervisorAssignment(@PathVariable Integer id, @RequestBody SupervisorAssignmentDTO updatedAssignmentDTO) {
        Optional<SupervisorAssignmentDTO> updatedAssignment = supervisorAssignmentService.updateSupervisorAssignment(id, updatedAssignmentDTO);
        return updatedAssignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupervisorAssignment(@PathVariable Integer id) {
        boolean deleted = supervisorAssignmentService.deleteSupervisorAssignment(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

