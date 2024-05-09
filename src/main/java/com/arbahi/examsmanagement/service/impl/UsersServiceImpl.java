package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.entity.User;
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
    public User createUser(User user) {
        return usersRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        Optional<User> user= usersRepository.findById(userId);
        if (user.isPresent())
            return user.orElse(null);
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User updateUser(Integer userId, User updatedUser) throws UserNotFoundException {
        Optional<User> optionalUser = usersRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

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
