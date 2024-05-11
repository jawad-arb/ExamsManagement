package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;
import com.arbahi.examsmanagement.dtoMapper.AbsenceControllerAssignmentDTOMapper;
import com.arbahi.examsmanagement.entity.AbsenceControllerAssignment;
import com.arbahi.examsmanagement.repository.AbsenceControllerAssignmentRepository;
import com.arbahi.examsmanagement.service.AbsenceControllerAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AbsenceControllerAssignmentServiceImpl implements AbsenceControllerAssignmentService {
    private final AbsenceControllerAssignmentRepository absenceControllerAssignmentRepository;
    private final AbsenceControllerAssignmentDTOMapper absenceControllerAssignmentDTOMapper;

    @Override
    public List<AbsenceControllerAssignmentDTO> getAllAbsenceControllerAssignments() {
        List<AbsenceControllerAssignment> assignments = absenceControllerAssignmentRepository.findAll();
        return assignments.stream()
                .map(absenceControllerAssignmentDTOMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AbsenceControllerAssignmentDTO> getAbsenceControllerAssignmentById(Integer id) {
        Optional<AbsenceControllerAssignment> assignment = absenceControllerAssignmentRepository.findById(id);
        return assignment.map(absenceControllerAssignmentDTOMapper::convertToDTO);
    }

    @Override
    public AbsenceControllerAssignmentDTO createAbsenceControllerAssignment(AbsenceControllerAssignmentDTO assignmentDTO) {
        AbsenceControllerAssignment assignment = absenceControllerAssignmentDTOMapper.convertToEntity(assignmentDTO);
        AbsenceControllerAssignment savedAssignment = absenceControllerAssignmentRepository.save(assignment);
        return absenceControllerAssignmentDTOMapper.convertToDTO(savedAssignment);
    }

    @Override
    public Optional<AbsenceControllerAssignmentDTO> updateAbsenceControllerAssignment(Integer id, AbsenceControllerAssignmentDTO updatedAssignmentDTO) {
        Optional<AbsenceControllerAssignment> optionalAssignment = absenceControllerAssignmentRepository.findById(id);
        if (optionalAssignment.isPresent()) {
            AbsenceControllerAssignment existingAssignment = optionalAssignment.get();
            existingAssignment.setId(id);
            AbsenceControllerAssignment updatedAssignment = absenceControllerAssignmentDTOMapper.convertToEntity(updatedAssignmentDTO);
            AbsenceControllerAssignment savedAssignment = absenceControllerAssignmentRepository.save(updatedAssignment);
            return Optional.of(absenceControllerAssignmentDTOMapper.convertToDTO(savedAssignment));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteAbsenceControllerAssignment(Integer id) {
        Optional<AbsenceControllerAssignment> optionalAssignment = absenceControllerAssignmentRepository.findById(id);
        if (optionalAssignment.isPresent()) {
            absenceControllerAssignmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
