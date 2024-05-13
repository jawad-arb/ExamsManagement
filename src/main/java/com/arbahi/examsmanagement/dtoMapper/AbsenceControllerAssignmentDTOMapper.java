package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;
import com.arbahi.examsmanagement.entity.AbsenceControllerAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AbsenceControllerAssignmentDTOMapper {

     AbsenceControllerAssignmentDTO convertToDTO(AbsenceControllerAssignment absenceControllerAssignment);
     AbsenceControllerAssignment convertToEntity(AbsenceControllerAssignmentDTO absenceControllerAssignmentDto);
    List<AbsenceControllerAssignmentDTO> convertToDTOs(List<AbsenceControllerAssignment> absenceControllerAssignment);
    List<AbsenceControllerAssignment> convertToEntities(List<AbsenceControllerAssignmentDTO> absenceControllerAssignmentDto);
}
