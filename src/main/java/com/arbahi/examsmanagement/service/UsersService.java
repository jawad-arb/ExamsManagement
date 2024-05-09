package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.entity.User;

import java.util.List;

public interface UsersService {

    User createUser(User user);

    User getUserById(Integer userId);

    List<User> getAllUsers();

    User updateUser(Integer userId, User updatedUser) throws UserNotFoundException;

    void deleteUser(Integer userId);
}
