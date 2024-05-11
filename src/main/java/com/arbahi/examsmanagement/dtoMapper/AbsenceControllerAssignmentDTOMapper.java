package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;
import com.arbahi.examsmanagement.entity.AbsenceControllerAssignment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AbsenceControllerAssignmentDTOMapper {

    private final ModelMapper modelMapper;

    public AbsenceControllerAssignmentDTO convertToDTO(AbsenceControllerAssignment absenceControllerAssignment){
        return modelMapper.map(absenceControllerAssignment, AbsenceControllerAssignmentDTO.class);
    }
    public AbsenceControllerAssignment convertToEntity(AbsenceControllerAssignmentDTO absenceControllerAssignmentDto){
        return modelMapper.map(absenceControllerAssignmentDto, AbsenceControllerAssignment.class);
    }
}
