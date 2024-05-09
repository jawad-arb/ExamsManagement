package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.Exceptions.TeacherGroupNotFound;
import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.dto.TeacherGroupDTO;
import com.arbahi.examsmanagement.dto.UsersDTO;
import com.arbahi.examsmanagement.dtoMapper.TeacherGroupDTOMapper;
import com.arbahi.examsmanagement.dtoMapper.UsersDTOMapper;
import com.arbahi.examsmanagement.entity.TeacherGroup;
import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.repository.TeacherGroupRepository;
import com.arbahi.examsmanagement.repository.UsersRepository;
import com.arbahi.examsmanagement.service.TeacherGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherGroupServiceImpl implements TeacherGroupService {

    private final TeacherGroupRepository teacherGroupRepository;

    private final UsersRepository usersRepository;

    private final TeacherGroupDTOMapper teacherGroupDTOMapper;

    private final UsersDTOMapper usersDTOMapper;

    @Override
    public TeacherGroupDTO addTeacherGroup(TeacherGroup teacherGroup) {
        TeacherGroup savedTeacherGroup = teacherGroupRepository.save(teacherGroup);
        return teacherGroupDTOMapper.convertToDTO(savedTeacherGroup);
    }

    @Override
    public void removeTeacherGroup(Integer teacherGroupId) {
        if (teacherGroupRepository.existsById(teacherGroupId)) {
            teacherGroupRepository.deleteById(teacherGroupId);
        }
    }

    @Override
    public TeacherGroupDTO updateTeacherGroup(TeacherGroup teacherGroup) {
        TeacherGroup updatedTeacherGroup = teacherGroupRepository.save(teacherGroup);
        return teacherGroupDTOMapper.convertToDTO(updatedTeacherGroup);
    }

    @Override
    public List<UsersDTO> getAllTeachersFromTeacherGroupByName(String teacherGroupName) {
        TeacherGroup teacherGroup = teacherGroupRepository.findByName(teacherGroupName);
        List<User> teachers = teacherGroup.getTeachers();
        return teachers.stream().map(usersDTOMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UsersDTO> getAllTeachersFromTeacherGroupById(Integer teacherGroupId) {
        TeacherGroup teacherGroup = teacherGroupRepository.findById(teacherGroupId).orElseThrow(() -> new IllegalArgumentException("TeacherGroup not found"));
        List<User> teachers = teacherGroup.getTeachers();
        return teachers.stream().map(usersDTOMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TeacherGroupDTO addTeacherToTeachersGroup(Integer teacherId, Integer groupId) {
        User teacher = usersRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        TeacherGroup teacherGroup = teacherGroupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("TeacherGroup not found"));

        teacherGroup.getTeachers().add(teacher);

        teacherGroupRepository.save(teacherGroup);

        return teacherGroupDTOMapper.convertToDTO(teacherGroup);
    }

    @Override
    public void removeTeacherFromTeachersGroup(Integer teacherId, Integer groupId) throws UserNotFoundException, TeacherGroupNotFound {
        User teacher = usersRepository.findById(teacherId)
                .orElseThrow(() -> new UserNotFoundException());
        TeacherGroup teacherGroup = teacherGroupRepository.findById(groupId)
                .orElseThrow(() -> new TeacherGroupNotFound());

        teacherGroup.getTeachers().remove(teacher);

        teacherGroupRepository.save(teacherGroup);
    }
}