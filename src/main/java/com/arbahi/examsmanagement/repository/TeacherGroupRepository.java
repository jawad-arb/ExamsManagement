package com.arbahi.examsmanagement.repository;

import com.arbahi.examsmanagement.entity.TeacherGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherGroupRepository extends JpaRepository<TeacherGroup,Integer> {
    TeacherGroup findByName(String name);
}
