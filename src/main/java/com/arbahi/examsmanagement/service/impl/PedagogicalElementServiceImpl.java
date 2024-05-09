package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.dto.PedagogicalElementDTO;
import com.arbahi.examsmanagement.dtoMapper.PedagogicalElementDTOMapper;
import com.arbahi.examsmanagement.entity.PedagogicalElement;
import com.arbahi.examsmanagement.entity.User;
import com.arbahi.examsmanagement.enums.UserType;
import com.arbahi.examsmanagement.repository.PedagogicalElementRepository;
import com.arbahi.examsmanagement.repository.UsersRepository;
import com.arbahi.examsmanagement.service.PedagogicalElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedagogicalElementServiceImpl implements PedagogicalElementService {

    private final PedagogicalElementRepository elementRepository;
    private final PedagogicalElementDTOMapper elementDTOMapper;
    private final UsersRepository usersRepository;

    @Override
    public PedagogicalElementDTO addElement(PedagogicalElement element) {
        if (element.getCoordinator() == null) {
            User defaultCoordinator = usersRepository.findFirstByType(UserType.TEACHER);
            element.setCoordinator(defaultCoordinator);
        }

        PedagogicalElement savedElement = elementRepository.save(element);
        return elementDTOMapper.convertToDTO(savedElement);
    }

    @Override
    public void removeElement(Integer elementId) {
        elementRepository.deleteById(elementId);
    }

    @Override
    public PedagogicalElementDTO updateElement(Integer elementId, PedagogicalElement updatedElement) {
        Optional<PedagogicalElement> existingElementOptional = elementRepository.findById(elementId);

        if (existingElementOptional.isPresent()) {
            PedagogicalElement existingElement = existingElementOptional.get();

            existingElement.setTitle(updatedElement.getTitle());
            existingElement.setLevel(updatedElement.getLevel());
            existingElement.setType(updatedElement.getType());

            // from the Update we cannot update the coordinator
            if (updatedElement.getCoordinator() != null) {
                existingElement.setCoordinator(updatedElement.getCoordinator());
            }

            PedagogicalElement savedElement = elementRepository.save(existingElement);
            return elementDTOMapper.convertToDTO(savedElement);
        } else {
            return null;
        }
    }
    @Override
    public PedagogicalElementDTO getElementById(Integer elementId) {
        return elementRepository.findById(elementId)
                .map(elementDTOMapper::convertToDTO)
                .orElse(null);
    }

    @Override
    public PedagogicalElementDTO getElementByCoordinatorId(Integer coordinatorId) {
        PedagogicalElement element = elementRepository.findByCoordinatorId(coordinatorId);
        return elementDTOMapper.convertToDTO(element);
    }

    @Override
    public List<PedagogicalElementDTO> getAllElements() {
        return elementRepository.findAll()
                .stream()
                .map(elementDTOMapper::convertToDTO)
                .collect(Collectors.toList());
    }


}
