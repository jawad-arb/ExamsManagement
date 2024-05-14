//package com.arbahi.examsmanagement.restController;
//
//import com.arbahi.examsmanagement.Exceptions.TeacherGroupNotFound;
//import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
//import com.arbahi.examsmanagement.dto.TeacherGroupDTO;
//import com.arbahi.examsmanagement.dto.UsersDTO;
//import com.arbahi.examsmanagement.entity.TeacherGroup;
//import com.arbahi.examsmanagement.service.TeacherGroupService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/teacher-groups")
//@RequiredArgsConstructor
//@Validated
//public class TeacherGroupController {
//
//    private final TeacherGroupService teacherGroupService;
//
//    @PostMapping
//    public ResponseEntity<TeacherGroupDTO> addTeacherGroup(@Valid @RequestBody TeacherGroup teacherGroup) {
//        TeacherGroupDTO createdGroup = teacherGroupService.addTeacherGroup(teacherGroup);
//        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{groupId}")
//    public void removeTeacherGroup(@PathVariable Integer groupId) {
//        teacherGroupService.removeTeacherGroup(groupId);
//    }
//
//    @PutMapping("/{groupId}")
//    public ResponseEntity<TeacherGroupDTO> updateTeacherGroup(@PathVariable Integer groupId, @Valid @RequestBody TeacherGroup teacherGroup) {
//        teacherGroup.setGroupId(groupId);
//        TeacherGroupDTO updatedGroup = teacherGroupService.updateTeacherGroup(teacherGroup);
//        return ResponseEntity.ok(updatedGroup);
//    }
//
//
//    @GetMapping("/by-name/{name}")
//    public ResponseEntity<List<UsersDTO>> getAllTeachersFromTeacherGroupByName(@PathVariable String name) {
//        List<UsersDTO> teachers = teacherGroupService.getAllTeachersFromTeacherGroupByName(name);
//        return ResponseEntity.ok(teachers);
//    }
//
//    @GetMapping("/{groupId}/teachers")
//    public ResponseEntity<List<UsersDTO>> getAllTeachersFromTeacherGroupById(@PathVariable Integer groupId) {
//        List<UsersDTO> teachers = teacherGroupService.getAllTeachersFromTeacherGroupById(groupId);
//        return ResponseEntity.ok(teachers);
//    }
//
//    @PostMapping("/{groupId}/teachers/{teacherId}")
//    public ResponseEntity<TeacherGroupDTO> addTeacherToTeachersGroup(@PathVariable Integer groupId, @PathVariable Integer teacherId) {
//        TeacherGroupDTO updatedGroup = teacherGroupService.addTeacherToTeachersGroup(teacherId, groupId);
//        return ResponseEntity.ok(updatedGroup);
//    }
//
//    @DeleteMapping("/{groupId}/teachers/{teacherId}")
//    public void removeTeacherFromTeachersGroup(@PathVariable Integer groupId, @PathVariable Integer teacherId) throws UserNotFoundException, TeacherGroupNotFound {
//        teacherGroupService.removeTeacherFromTeachersGroup(teacherId, groupId);
//    }
//}