package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.entity.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {UsersDTOMapper.class, RoomDTOMapper.class})
public interface ExamDTOMapper {

     ExamDTO convertToDTO(Exam exam);
     Exam convertToEntity(ExamDTO examDTO);
     List<ExamDTO> convertToDTOs(List<Exam> exam);
     List<Exam> convertToEntities(List<ExamDTO> examDTO);
}

