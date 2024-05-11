package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.RoomDTO;
import com.arbahi.examsmanagement.entity.AbsenceControllerAssignment;
import com.arbahi.examsmanagement.entity.Exam;
import com.arbahi.examsmanagement.entity.Room;
import com.arbahi.examsmanagement.entity.SupervisorAssignment;
import com.arbahi.examsmanagement.repository.AbsenceControllerAssignmentRepository;
import com.arbahi.examsmanagement.repository.ExamRepository;
import com.arbahi.examsmanagement.repository.SupervisorAssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomDTOMapper {

    private final ModelMapper modelMapper;
    private final ExamRepository examRepository;
    private final SupervisorAssignmentRepository supervisorAssignmentRepository;
    private final AbsenceControllerAssignmentRepository absenceControllerAssignmentRepository;

    public RoomDTO convertToDto(Room room) {
        RoomDTO roomDTO = modelMapper.map(room, RoomDTO.class);
        roomDTO.setExamsId(room.getExams().stream().map(Exam::getId).collect(Collectors.toList()));
        roomDTO.setInvigilatorAssignmentsId(room.getInvigilatorAssignments().stream().map(SupervisorAssignment::getId).collect(Collectors.toList()));
        roomDTO.setAbsenceControllerAssignmentsId(room.getAbsenceControllerAssignments().stream().map(AbsenceControllerAssignment::getId).collect(Collectors.toList()));
        return roomDTO;
    }

    public Room convertToEntity(RoomDTO roomDTO) {
        Room room = modelMapper.map(roomDTO, Room.class);

        // Fetch and set the exams based on the IDs provided in the DTO
        Set<Exam> exams = roomDTO.getExamsId().stream()
                .map(examId -> examRepository.findById(examId).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        room.setExams(exams);

        Set<SupervisorAssignment> supervisorAssignments = roomDTO.getInvigilatorAssignmentsId().stream()
                .map(assignmentId -> supervisorAssignmentRepository.findById(assignmentId).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        room.setInvigilatorAssignments(supervisorAssignments);

        Set<AbsenceControllerAssignment> absenceControllerAssignments = roomDTO.getAbsenceControllerAssignmentsId().stream()
                .map(assignmentId -> absenceControllerAssignmentRepository.findById(assignmentId).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        room.setAbsenceControllerAssignments(absenceControllerAssignments);

        return room;
    }
}
