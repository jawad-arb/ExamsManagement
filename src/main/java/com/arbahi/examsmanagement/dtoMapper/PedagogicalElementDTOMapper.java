package com.arbahi.examsmanagement.dtoMapper;

import com.arbahi.examsmanagement.dto.PedagogicalElementDTO;
import com.arbahi.examsmanagement.entity.PedagogicalElement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = UsersDTOMapper.class)
public interface PedagogicalElementDTOMapper {

     PedagogicalElementDTO convertToDTO(PedagogicalElement pedagogicalElement);

     PedagogicalElement convertToEntity(PedagogicalElementDTO pedagogicalElementDTO);

    List<PedagogicalElementDTO> convertToDTOs(List<PedagogicalElement> pedagogicalElements);

    List<PedagogicalElement> convertToEntities(List<PedagogicalElementDTO> pedagogicalElementDTOs);


}