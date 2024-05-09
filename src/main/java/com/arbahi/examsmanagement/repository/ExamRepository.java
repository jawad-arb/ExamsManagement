package com.arbahi.examsmanagement.repository;

import com.arbahi.examsmanagement.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Integer> {
}
