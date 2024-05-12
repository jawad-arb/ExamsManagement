package com.arbahi.examsmanagement.controller;

import com.arbahi.examsmanagement.dto.ExamDTO;
import com.arbahi.examsmanagement.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public ResponseEntity<List<ExamDTO>> getAllExams() {
        List<ExamDTO> exams = examService.getAllExams();
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable Integer id) {
        ExamDTO exam = examService.getExamById(id);
        if (exam != null) {
            return ResponseEntity.ok(exam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTO exam) throws Exception {
        ExamDTO createdExam = examService.createExam(exam);
        return ResponseEntity.ok(createdExam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamDTO> updateExam(@PathVariable Integer id, @RequestBody ExamDTO updatedExam) throws Exception {
        ExamDTO exam = examService.updateExam(id, updatedExam);
        if (exam != null) {
            return ResponseEntity.ok(exam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Integer id) {
        boolean deleted = examService.deleteExam(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

