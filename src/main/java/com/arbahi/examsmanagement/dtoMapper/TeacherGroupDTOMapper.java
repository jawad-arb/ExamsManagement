package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.TeacherGroupDTO;
import com.arbahi.examsmanagement.entity.TeacherGroup;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = UsersDTOMapper.class )
public interface TeacherGroupDTOMapper {

     TeacherGroupDTO convertToDTO(TeacherGroup teacherGroup);
     TeacherGroup convertToEntity(TeacherGroupDTO teacherGroupDTO);
    public List<TeacherGroupDTO> convertToDTOs(List<TeacherGroup> teacherGroups);
    public List<TeacherGroup> convertToEntities(List<TeacherGroupDTO> teacherGroupDTOs);

}
