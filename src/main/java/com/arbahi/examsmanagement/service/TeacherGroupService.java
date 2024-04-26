package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.Exceptions.TeacherGroupNotFound;
import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.dto.TeacherGroupDTO;
import com.arbahi.examsmanagement.dto.UsersDTO;
import com.arbahi.examsmanagement.entity.TeacherGroup;

import java.util.List;

public interface TeacherGroupService {

    TeacherGroupDTO addTeacherGroup(TeacherGroup teacherGroup);

    void removeTeacherGroup(Integer teacherGroupId);

    TeacherGroupDTO updateTeacherGroup(TeacherGroup teacherGroup);

    List<UsersDTO> getAllTeachersFromTeacherGroupByName(String teacherGroupName);

    List<UsersDTO> getAllTeachersFromTeacherGroupById(Integer teacherGroupId);

    TeacherGroupDTO addTeacherToTeachersGroup(Integer teacherId, Integer groupId);

    void removeTeacherFromTeachersGroup(Integer teacherId, Integer groupId) throws UserNotFoundException, TeacherGroupNotFound;
}