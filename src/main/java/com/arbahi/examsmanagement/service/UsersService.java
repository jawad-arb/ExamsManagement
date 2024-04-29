package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.entity.Users;

import java.util.List;

public interface UsersService {

    Users createUser(Users user);

    Users getUserById(Integer userId);

    List<Users> getAllUsers();

    Users updateUser(Integer userId, Users updatedUser) throws UserNotFoundException;

    void deleteUser(Integer userId);
}
