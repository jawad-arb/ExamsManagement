package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.dtoMapper.ExamDTOMapper;
import com.arbahi.examsmanagement.entity.Exam;
import com.arbahi.examsmanagement.repository.ExamRepository;
import com.arbahi.examsmanagement.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ExamDTOMapper examDTOMapper;

    @Override
    public List<ExamDTO> getAllExams() {
        List<Exam> exams = examRepository.findAll();
        return exams.stream()
                .map(examDTOMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExamDTO getExamById(Integer id) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        return optionalExam.map(examDTOMapper::convertToDTO).orElse(null);
    }

    @Override
    public ExamDTO createExam(ExamDTO examDTO) {
        Exam exam = examDTOMapper.convertToEntity(examDTO);
        Exam savedExam = examRepository.save(exam);
        return examDTOMapper.convertToDTO(savedExam);
    }

    @Override
    public ExamDTO updateExam(Integer id, ExamDTO updatedExamDTO) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if (optionalExam.isPresent()) {
            Exam existingExam = optionalExam.get();
            existingExam.setId(id);
            Exam updatedExam = examDTOMapper.convertToEntity(updatedExamDTO);
            Exam savedExam = examRepository.save(updatedExam);
            return examDTOMapper.convertToDTO(savedExam);
        }
        return null;
    }

    @Override
    public boolean deleteExam(Integer id) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if (optionalExam.isPresent()) {
            examRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
