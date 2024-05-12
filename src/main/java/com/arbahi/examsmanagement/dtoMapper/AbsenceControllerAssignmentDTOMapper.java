package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.AbsenceControllerAssignmentDTO;
import com.arbahi.examsmanagement.entity.AbsenceControllerAssignment;
import com.arbahi.examsmanagement.entity.Exam;
import com.arbahi.examsmanagement.entity.Room;
import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.repository.ExamRepository;
import com.arbahi.examsmanagement.repository.RoomRepository;
import com.arbahi.examsmanagement.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AbsenceControllerAssignmentDTOMapper {

    private final UsersRepository userRepository;
    private final ExamRepository examRepository;
    private final RoomRepository roomRepository;


    public AbsenceControllerAssignmentDTO convertToDTO(AbsenceControllerAssignment absenceControllerAssignment){
        AbsenceControllerAssignmentDTO dto = AbsenceControllerAssignmentDTO.builder()
                .id(absenceControllerAssignment.getId())
                .examId(absenceControllerAssignment.getExam().getId())
                .absenceControllerId(absenceControllerAssignment.getAbsenceController().getUserId())
                .roomId(absenceControllerAssignment.getRoom().getId())
                .build();
        return dto;
    }
    public AbsenceControllerAssignment convertToEntity(AbsenceControllerAssignmentDTO absenceControllerAssignmentDto){
        Optional<Exam> examOptional = examRepository.findById(absenceControllerAssignmentDto.getExamId());
        Optional<Room> roomOptional = roomRepository.findById(absenceControllerAssignmentDto.getRoomId());
        Optional<User> absenceController = userRepository.findById(absenceControllerAssignmentDto.getAbsenceControllerId());

        if (examOptional.isEmpty() || roomOptional.isEmpty() || absenceController.isEmpty()) {
            throw new EntityNotFoundException("One or more entities not found");
        }

        Exam exam =examOptional.get();
        Room room =roomOptional.get();
        User absenceUserController =absenceController.get();

        return AbsenceControllerAssignment.builder()
                .id(absenceControllerAssignmentDto.getId())
                .exam(exam)
                .room(room)
                .absenceController(absenceUserController)
                .build();

    }
}
