package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.SupervisorAssignmentDTO;
import com.arbahi.examsmanagement.entity.Exam;
import com.arbahi.examsmanagement.entity.Room;
import com.arbahi.examsmanagement.entity.SupervisorAssignment;
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
public class SupervisorAssignmentDTOMapper {

    private final UsersRepository userRepository;
    private final RoomRepository roomRepository;
    private final ExamRepository examRepository;

    public SupervisorAssignmentDTO convertToDTO(SupervisorAssignment supervisorAssignment){
        SupervisorAssignmentDTO s= SupervisorAssignmentDTO.builder()
                .id(supervisorAssignment.getId())
                .examId(supervisorAssignment.getExam().getId())
                .invigilatorId(supervisorAssignment.getInvigilator().getUserId())
                .roomId(supervisorAssignment.getRoom().getId())
                .build();
        return s;
    }
    public SupervisorAssignment convertToEntity(SupervisorAssignmentDTO supervisorAssignmentDTO){
        Optional<Exam> examOptional = examRepository.findById(supervisorAssignmentDTO.getExamId());
        Optional<Room> roomOptional = roomRepository.findById(supervisorAssignmentDTO.getRoomId());
        Optional<User> invigilatorOptional = userRepository.findById(supervisorAssignmentDTO.getInvigilatorId());

        if (examOptional.isEmpty() || roomOptional.isEmpty() || invigilatorOptional.isEmpty()) {
            throw new EntityNotFoundException("One or more entities not found");
        }

        Exam exam = examOptional.get();
        Room room = roomOptional.get();
        User invigilator = invigilatorOptional.get();

        return SupervisorAssignment.builder()
                .id(supervisorAssignmentDTO.getId())
                .exam(exam)
                .room(room)
                .invigilator(invigilator)
                .build();
    }
}
