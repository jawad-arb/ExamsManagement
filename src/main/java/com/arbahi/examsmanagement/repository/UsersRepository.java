package com.arbahi.examsmanagement.repository;

import com.arbahi.examsmanagement.entity.Users;
import com.arbahi.examsmanagement.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findFirstByType(UserType userType);
}
