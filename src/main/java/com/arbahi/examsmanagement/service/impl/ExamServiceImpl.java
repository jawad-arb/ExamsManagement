package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.entity.Exam;
import com.arbahi.examsmanagement.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Override
    public List<ExamDTO> getAllExams() {
        return List.of();
    }

    @Override
    public ExamDTO getExamById(Long id) {
        return null;
    }

    @Override
    public ExamDTO createExam(Exam exam) {
        return null;
    }

    @Override
    public ExamDTO updateExam(Long id, Exam updatedExam) {
        return null;
    }

    @Override
    public boolean deleteExam(Long id) {
        return false;
    }
}
