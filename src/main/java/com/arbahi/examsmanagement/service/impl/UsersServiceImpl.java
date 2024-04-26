package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.entity.Users;
import com.arbahi.examsmanagement.repository.UsersRepository;
import com.arbahi.examsmanagement.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    @Override
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> getUserById(Integer userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users updateUser(Integer userId, Users updatedUser) throws UserNotFoundException {
        Optional<Users> optionalUser = usersRepository.findById(userId);

        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();

            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setType(updatedUser.getType());

            return usersRepository.save(existingUser);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }
}
