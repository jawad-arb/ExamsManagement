package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.entity.Exam;
import com.arbahi.examsmanagement.entity.Room;
import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.enums.ExamType;
import com.arbahi.examsmanagement.enums.Semester;
import com.arbahi.examsmanagement.enums.Session;
import com.arbahi.examsmanagement.repository.RoomRepository;
import com.arbahi.examsmanagement.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ExamDTOMapper {
    private final UsersRepository usersRepository;
    private final RoomRepository roomRepository;


    public ExamDTO convertToDTO(Exam exam) {
        ExamDTO examDTO=new ExamDTO();
        examDTO.setExamId(exam.getId());
        examDTO.setSemester(String.valueOf(exam.getSemester()));
        examDTO.setSession(String.valueOf(exam.getSession()));
        examDTO.setType(String.valueOf(exam.getType()));
        examDTO.setStartTime(LocalDateTime.from(exam.getStartTime()));
        examDTO.setActualDuration(exam.getActualDuration());
        examDTO.setCoordinatorId(new ArrayList<>());
        for(User u: exam.getCoordinators()){
            examDTO.getCoordinatorId().add(u.getUserId());
        }
        examDTO.setRoomIds(new ArrayList<>());
        for(Room r: exam.getRooms()){
            examDTO.getRoomIds().add(r.getId());
        }
        examDTO.setInvigilatorIds(new ArrayList<>());
        for(User u: exam.getInvigilators()){
            examDTO.getInvigilatorIds().add(u.getUserId());
        }
        examDTO.setAbsenceControllerIds(new ArrayList<>());
        for(User u: exam.getAbsenceControllers()){
            examDTO.getAbsenceControllerIds().add(u.getUserId());
        }
        return examDTO;
    }

    public Exam convertToEntity(ExamDTO examDTO) throws Exception {
        Exam exam =new Exam();
        exam.setId(examDTO.getExamId());
        exam.setSemester(Semester.valueOf(examDTO.getSemester()));  // Assuming semester is an integer
        exam.setSession(Session.valueOf(examDTO.getSession()));
        exam.setType(ExamType.valueOf(examDTO.getType()));
        exam.setStartTime(LocalDateTime.from(examDTO.getStartTime()));
        exam.setActualDuration(examDTO.getActualDuration());
        exam.setCoordinators(examDTO.getCoordinatorId().stream()
                .map(usersRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList()));

        List<Room> rooms = examDTO.getRoomIds().stream()
                .map(roomRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        exam.setRooms(rooms);
        List<User> invigilators = examDTO.getInvigilatorIds().stream()
                .map(usersRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        exam.setInvigilators(invigilators);

// Absence Controllers (similar logic)
        List<User> absenceControllers = examDTO.getAbsenceControllerIds().stream()
                .map(usersRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        exam.setAbsenceControllers(absenceControllers);
        return exam;
    }
}

