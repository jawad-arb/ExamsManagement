package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.PedagogicalElementDTO;
import com.arbahi.examsmanagement.entity.PedagogicalElement;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedagogicalElementDTOMapper {

    private final ModelMapper modelMapper;

    public PedagogicalElementDTO convertToDTO(PedagogicalElement pedagogicalElement) {
        return modelMapper.map(pedagogicalElement, PedagogicalElementDTO.class);
    }

    public PedagogicalElement convertToEntity(PedagogicalElementDTO pedagogicalElementDTO) {
        return modelMapper.map(pedagogicalElementDTO, PedagogicalElement.class);
    }

}