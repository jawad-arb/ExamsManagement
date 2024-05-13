package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.UsersDTO;
import com.arbahi.examsmanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public  interface UsersDTOMapper {
    UsersDTO convertToDTO(User user);
    User convertToEntity(UsersDTO usersDTO);
    List<UsersDTO> convertToDTOs(List<User> users);
    List<User> convertToEntities(List<UsersDTO> usersDTOs);
}
