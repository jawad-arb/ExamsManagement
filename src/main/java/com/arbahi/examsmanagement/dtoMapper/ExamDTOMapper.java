package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.entity.Exam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamDTOMapper {
    
    private final ModelMapper modelMapper;

    public ExamDTO convertToDto(Exam exam) {
        return modelMapper.map(exam, ExamDTO.class);
    }

    public Exam convertToEntity(ExamDTO examDTO) {
        return modelMapper.map(examDTO, Exam.class);
    }
}

