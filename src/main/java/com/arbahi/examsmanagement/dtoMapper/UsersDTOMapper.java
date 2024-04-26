package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.UsersDTO;
import com.arbahi.examsmanagement.entity.Users;
import com.arbahi.examsmanagement.enums.UserType;
import org.springframework.stereotype.Component;

@Component
public class UsersDTOMapper {
    public UsersDTO convertToDTO(Users user) {
        UsersDTO dto = new UsersDTO();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setType(user.getType().name());
        return dto;
    }
    public Users convertToEntity(UsersDTO dto) {
        Users user = new Users();
        user.setUserId(dto.getUserId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword("password");
        user.setType(UserType.valueOf(dto.getType()));
        return user;
    }

}
