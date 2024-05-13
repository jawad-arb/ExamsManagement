package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.dto.SupervisorAssignmentDTO;
import com.arbahi.examsmanagement.dtoMapper.SupervisorAssignmentDTOMapper;
import com.arbahi.examsmanagement.entity.SupervisorAssignment;
import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.enums.UserType;
import com.arbahi.examsmanagement.repository.SupervisorAssignmentRepository;
import com.arbahi.examsmanagement.repository.UsersRepository;
import com.arbahi.examsmanagement.service.SupervisorAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupervisorAssignmentServiceImpl implements SupervisorAssignmentService {
    private final SupervisorAssignmentRepository supervisorAssignmentRepository;
    private final SupervisorAssignmentDTOMapper supervisorAssignmentDTOMapper;
    private final UsersRepository userRepository;

    @Override
    public List<SupervisorAssignmentDTO> getAllSupervisorAssignments() {
        List<SupervisorAssignment> assignments = supervisorAssignmentRepository.findAll();
        return assignments.stream()
                .map(supervisorAssignmentDTOMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SupervisorAssignmentDTO> getSupervisorAssignmentById(Integer id) {
        Optional<SupervisorAssignment> assignment = supervisorAssignmentRepository.findById(id);
        return assignment.map(supervisorAssignmentDTOMapper::convertToDTO);
    }

    @Override
    public SupervisorAssignmentDTO createSupervisorAssignment(SupervisorAssignmentDTO assignmentDTO) throws Exception {

        Optional<User> invigilatorOptional = userRepository.findById(assignmentDTO.getInvigilator().getUserId());
        if (invigilatorOptional.isEmpty()) {
            throw new Exception("Invigilator user not found");
        }

        User invigilator = invigilatorOptional.get();
        if (invigilator.getType() != UserType.TEACHER) {
            throw new Exception("Invigilator must have the TEACHER role");
        }

        SupervisorAssignment assignment = supervisorAssignmentDTOMapper.convertToEntity(assignmentDTO);
        SupervisorAssignment savedAssignment = supervisorAssignmentRepository.save(assignment);
        return supervisorAssignmentDTOMapper.convertToDTO(savedAssignment);
    }


    @Override
    public Optional<SupervisorAssignmentDTO> updateSupervisorAssignment(Integer id, SupervisorAssignmentDTO updatedAssignmentDTO) {
        Optional<SupervisorAssignment> optionalAssignment = supervisorAssignmentRepository.findById(id);
        if (optionalAssignment.isPresent()) {
            SupervisorAssignment updatedAssignment = supervisorAssignmentDTOMapper.convertToEntity(updatedAssignmentDTO);
            updatedAssignment.setId(id);
            SupervisorAssignment savedAssignment = supervisorAssignmentRepository.save(updatedAssignment);
            return Optional.of(supervisorAssignmentDTOMapper.convertToDTO(savedAssignment));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteSupervisorAssignment(Integer id) {
        Optional<SupervisorAssignment> optionalAssignment = supervisorAssignmentRepository.findById(id);
        if (optionalAssignment.isPresent()) {
            supervisorAssignmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
