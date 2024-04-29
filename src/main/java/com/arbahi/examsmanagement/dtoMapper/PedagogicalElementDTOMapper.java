package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.PedagogicalElementDTO;
import com.arbahi.examsmanagement.entity.PedagogicalElement;
import com.arbahi.examsmanagement.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedagogicalElementDTOMapper {
    private final UsersService usersService;

    public PedagogicalElementDTO convertToDTO(PedagogicalElement element) {
        PedagogicalElementDTO dto = new PedagogicalElementDTO();
        dto.setId(element.getId());
        dto.setTitle(element.getTitle());
        dto.setLevel(element.getLevel());
        dto.setType(element.getType());
        dto.setCoordinatorId(element.getCoordinator().getUserId());
        return dto;
    }

    public PedagogicalElement convertToEntity(PedagogicalElementDTO dto) {
        PedagogicalElement element = new PedagogicalElement();
        element.setTitle(dto.getTitle());
        element.setLevel(dto.getLevel());
        element.setType(dto.getType());
        element.setCoordinator(usersService.getUserById(dto.getId()));
        return element;
    }
}
