package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.RoomDTO;
import com.arbahi.examsmanagement.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {AbsenceControllerAssignmentDTOMapper.class, SupervisorAssignmentDTOMapper.class, ExamDTOMapper.class})
public interface RoomDTOMapper {

     RoomDTO convertToDTO(Room room);
     Room convertToEntity(RoomDTO roomDTO);
    List<RoomDTO> convertToDTOs(List<Room> rooms);
    List<Room> convertToEntities(List<RoomDTO> roomDTOs);
}
