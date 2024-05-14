package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.dto.UsersDTO;

import java.util.List;

public interface UsersService {

    UsersDTO createUser(UsersDTO user);

    UsersDTO getUserById(Integer userId) throws UserNotFoundException;

    List<UsersDTO> getAllUsers();

    UsersDTO updateUser(Integer userId, UsersDTO updatedUser) throws UserNotFoundException;

    void deleteUser(Integer userId);
}
