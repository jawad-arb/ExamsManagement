package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.SupervisorAssignmentDTO;
import com.arbahi.examsmanagement.entity.SupervisorAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {UsersDTOMapper.class, RoomDTOMapper.class, ExamDTOMapper.class})
public interface SupervisorAssignmentDTOMapper {

        SupervisorAssignmentDTO convertToDTO(SupervisorAssignment supervisorAssignment);
        SupervisorAssignment convertToEntity(SupervisorAssignmentDTO supervisorAssignmentDTO);
        List<SupervisorAssignmentDTO> convertToDTOs(List<SupervisorAssignment> supervisorAssignments);
        List<SupervisorAssignment> convertToEntities(List<SupervisorAssignmentDTO> SupervisorAssignmentDTOs);
}