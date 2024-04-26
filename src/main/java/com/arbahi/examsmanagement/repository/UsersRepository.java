package com.arbahi.examsmanagement.repository;

import com.arbahi.examsmanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users,Integer> {
}
