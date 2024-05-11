package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.entity.Exam;
import com.arbahi.examsmanagement.repository.RoomRepository;
import com.arbahi.examsmanagement.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExamDTOMapper {

    private final ModelMapper modelMapper;
    private final UsersRepository userRepository;
    private final RoomRepository roomRepository;

    public ExamDTO convertToDTO(Exam exam) {
        return modelMapper.map(exam, ExamDTO.class);
    }

    public Exam convertToEntity(ExamDTO examDTO) {
        modelMapper.typeMap(ExamDTO.class, Exam.class)
                .addMappings(mapper -> mapper.using(ctx -> userRepository.findById((Integer) ctx.getSource()).orElse(null))
                        .map(ExamDTO::getCoordinatorId, Exam::setCoordinators))
                .addMappings(mapper -> mapper.using(ctx -> roomRepository.findAllById((List<Integer>) ctx.getSource()))
                        .map(ExamDTO::getRoomIds, Exam::setRooms))
                .addMappings(mapper -> mapper.using(ctx -> userRepository.findAllById((List<Integer>) ctx.getSource()))
                        .map(ExamDTO::getInvigilatorIds, Exam::setInvigilators))
                .addMappings(mapper -> mapper.using(ctx -> userRepository.findAllById((List<Integer>) ctx.getSource()))
                        .map(ExamDTO::getAbsenceControllerIds, Exam::setAbsenceControllers));

        return modelMapper.map(examDTO, Exam.class);
    }



}

