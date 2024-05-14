package com.arbahi.examsmanagement.repository;

import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<User,Integer> {
    User findFirstByType(UserType userType);

    User findByEmail(String username);
}
