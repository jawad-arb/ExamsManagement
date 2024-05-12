package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;
import com.arbahi.examsmanagement.dtoMapper.AbsenceControllerAssignmentDTOMapper;
import com.arbahi.examsmanagement.entity.AbsenceControllerAssignment;
import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.enums.UserType;
import com.arbahi.examsmanagement.repository.AbsenceControllerAssignmentRepository;
import com.arbahi.examsmanagement.repository.UsersRepository;
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
    private final UsersRepository userRepository;

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
    public AbsenceControllerAssignmentDTO createAbsenceControllerAssignment(AbsenceControllerAssignmentDTO assignmentDTO) throws Exception {
        Optional<User> invigilatorOptional = userRepository.findById(assignmentDTO.getAbsenceControllerId());
        if (invigilatorOptional.isEmpty()) {
            throw new Exception("Invigilator user not found");
        }

        User invigilator = invigilatorOptional.get();
        if (invigilator.getType() != UserType.ADMIN) {
            throw new Exception("Absence controller must have the ADMIN role");
        }
        AbsenceControllerAssignment assignment = absenceControllerAssignmentDTOMapper.convertToEntity(assignmentDTO);
        AbsenceControllerAssignment savedAssignment = absenceControllerAssignmentRepository.save(assignment);
        return absenceControllerAssignmentDTOMapper.convertToDTO(savedAssignment);
    }

    @Override
    public Optional<AbsenceControllerAssignmentDTO> updateAbsenceControllerAssignment(Integer id, AbsenceControllerAssignmentDTO updatedAssignmentDTO) throws Exception {
        Optional<AbsenceControllerAssignment> optionalAssignment = absenceControllerAssignmentRepository.findById(id);
        if (optionalAssignment.isPresent()) {
            Optional<User> invigilatorOptional = userRepository.findById(id);
            if (invigilatorOptional.isEmpty()) {
                throw new Exception("Invigilator user not found");
            }
            User invigilator = invigilatorOptional.get();
            if (invigilator.getType() != UserType.ADMIN) {
                throw new Exception("Absence controller must have the ADMIN role");
            }
            AbsenceControllerAssignment updatedAssignment = absenceControllerAssignmentDTOMapper.convertToEntity(updatedAssignmentDTO);
            updatedAssignment.setId(id);
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
