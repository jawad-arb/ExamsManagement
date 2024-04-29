package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.dto.PedagogicalElementDTO;
import com.arbahi.examsmanagement.entity.PedagogicalElement;

import java.util.List;

public interface PedagogicalElementService {

    PedagogicalElementDTO addElement(PedagogicalElement element);

    void removeElement(Integer elementId);

    PedagogicalElementDTO updateElement(Integer elementId, PedagogicalElement updatedElement);

    PedagogicalElementDTO getElementById(Integer elementId);

    PedagogicalElementDTO getElementByCoordinatorId(Integer coordinatorId);

    List<PedagogicalElementDTO> getAllElements();

}
