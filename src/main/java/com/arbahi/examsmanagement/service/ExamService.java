package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.entity.Exam;

import java.util.List;

public interface ExamService {
    List<ExamDTO> getAllExams();

    ExamDTO getExamById(Long id);

    ExamDTO createExam(Exam exam);

    ExamDTO updateExam(Long id, Exam updatedExam);

    boolean deleteExam(Long id);
}
