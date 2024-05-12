package com.arbahi.examsmanagement.controller;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;
import com.arbahi.examsmanagement.service.AbsenceControllerAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/absence-controller-assignments")
@RequiredArgsConstructor
public class AbsenceControllerAssignmentController {

    private final AbsenceControllerAssignmentService absenceControllerAssignmentService;

    @GetMapping
    public ResponseEntity<List<AbsenceControllerAssignmentDTO>> getAllAbsenceControllerAssignments() {
        List<AbsenceControllerAssignmentDTO> assignments = absenceControllerAssignmentService.getAllAbsenceControllerAssignments();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbsenceControllerAssignmentDTO> getAbsenceControllerAssignmentById(@PathVariable Integer id) {
        Optional<AbsenceControllerAssignmentDTO> assignment = absenceControllerAssignmentService.getAbsenceControllerAssignmentById(id);
        return assignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AbsenceControllerAssignmentDTO> createAbsenceControllerAssignment(@RequestBody AbsenceControllerAssignmentDTO assignmentDTO) throws Exception {
        AbsenceControllerAssignmentDTO createdAssignment = absenceControllerAssignmentService.createAbsenceControllerAssignment(assignmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbsenceControllerAssignmentDTO> updateAbsenceControllerAssignment(@PathVariable Integer id, @RequestBody AbsenceControllerAssignmentDTO updatedAssignmentDTO) throws Exception {
        Optional<AbsenceControllerAssignmentDTO> updatedAssignment = absenceControllerAssignmentService.updateAbsenceControllerAssignment(id, updatedAssignmentDTO);
        return updatedAssignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsenceControllerAssignment(@PathVariable Integer id) {
        boolean deleted = absenceControllerAssignmentService.deleteAbsenceControllerAssignment(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

