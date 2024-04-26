package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.TeacherGroupDTO;
import com.arbahi.examsmanagement.entity.TeacherGroup;
import com.arbahi.examsmanagement.entity.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherGroupDTOMapper {

    public TeacherGroupDTO convertToDTO(TeacherGroup teacherGroup) {
        TeacherGroupDTO teacherGroupDTO = new TeacherGroupDTO();
        teacherGroupDTO.setGroupId(teacherGroup.getGroupId());
        teacherGroupDTO.setName(teacherGroup.getName());
        teacherGroupDTO.setDescription(teacherGroup.getDescription());

        List<Integer> teacherIds = new ArrayList<>();
        for (Users teacher : teacherGroup.getTeachers()) {
            teacherIds.add(teacher.getUserId());
        }
        teacherGroupDTO.setTeacherIds(teacherIds);

        return teacherGroupDTO;
    }

    public TeacherGroup convertToEntity(TeacherGroupDTO teacherGroupDTO) {
        TeacherGroup teacherGroup = new TeacherGroup();
        teacherGroup.setGroupId(teacherGroupDTO.getGroupId());
        teacherGroup.setName(teacherGroupDTO.getName());
        teacherGroup.setDescription(teacherGroupDTO.getDescription());

        List<Users> teachers = new ArrayList<>();
        for (Integer teacherId : teacherGroupDTO.getTeacherIds()) {
            Users teacher = new Users();
            teacher.setUserId(teacherId);
            teachers.add(teacher);
        }
        teacherGroup.setTeachers(teachers);

        return teacherGroup;
    }
}
