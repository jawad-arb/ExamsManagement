package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.dto.ExamDTO;

import java.util.List;

public interface ExamService {
    List<ExamDTO> getAllExams();

    ExamDTO getExamById(Integer id);

    ExamDTO createExam(ExamDTO examDTO);

    ExamDTO updateExam(Integer id, ExamDTO updatedExamDTO);

    boolean deleteExam(Integer id);
}
