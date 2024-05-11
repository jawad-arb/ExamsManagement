package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.SupervisorAssignmentDTO;
import com.arbahi.examsmanagement.entity.SupervisorAssignment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupervisorAssignmentDTOMapper {

    private final ModelMapper modelMapper;

    public SupervisorAssignmentDTO convertToDTO(SupervisorAssignment supervisorAssignment){
        return modelMapper.map(supervisorAssignment, SupervisorAssignmentDTO.class);
    }
    public SupervisorAssignment convertToEntity(SupervisorAssignmentDTO supervisorAssignmentDTO){
        return modelMapper.map(supervisorAssignmentDTO, SupervisorAssignment.class);
    }
}
