package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.dto.UsersDTO;
import com.arbahi.examsmanagement.dtoMapper.UsersDTOMapper;
import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.enums.UserType;
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
    private final UsersDTOMapper usersDTOMapper;

    @Override
    public UsersDTO createUser(UsersDTO userDTO) {
        User user=usersDTOMapper.convertToEntity(userDTO);
        return usersDTOMapper.convertToDTO(usersRepository.save(user));
    }

    @Override
    public UsersDTO getUserById(Integer userId) throws UserNotFoundException {
        Optional<User> user= usersRepository.findById(userId);
        if (user.isPresent())
            return usersDTOMapper.convertToDTO(user.get());
        throw new UserNotFoundException();
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        return usersDTOMapper.convertToDTOs(usersRepository.findAll());
    }

    @Override
    public UsersDTO updateUser(Integer userId, UsersDTO updatedUser) throws UserNotFoundException {
        Optional<User> optionalUser = usersRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            UserType userType = UserType.valueOf(updatedUser.getType());
            existingUser.setType(userType);
            existingUser.setPassword(updatedUser.getPassword());
            return usersDTOMapper.convertToDTO(usersRepository.save(existingUser));
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }
}
