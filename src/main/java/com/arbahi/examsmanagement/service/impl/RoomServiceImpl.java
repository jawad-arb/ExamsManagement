package com.arbahi.examsmanagement.service.impl;

import com.arbahi.examsmanagement.dto.RoomDTO;
import com.arbahi.examsmanagement.dtoMapper.ExamDTOMapper;
import com.arbahi.examsmanagement.dtoMapper.RoomDTOMapper;
import com.arbahi.examsmanagement.entity.Room;
import com.arbahi.examsmanagement.repository.RoomRepository;
import com.arbahi.examsmanagement.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomDTOMapper roomDTOMapper;
    private final ExamDTOMapper examDTOMapper;

    @Override
    public List<RoomDTO> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(roomDTOMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoomDTO> getRoomById(Integer id) {
        Optional<Room> room= roomRepository.findById(id);
        return Optional.ofNullable(roomDTOMapper.convertToDTO(room.orElse(null)));
    }

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = roomDTOMapper.convertToEntity(roomDTO);
        Room savedRoom=roomRepository.save(room);
        return roomDTOMapper.convertToDTO(savedRoom);
    }

    @Override
    public RoomDTO updateRoom(Integer id, RoomDTO updatedRoomDTO) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setName(updatedRoomDTO.getName());
            existingRoom.setCapacity(updatedRoomDTO.getCapacity());
            Room savedRoom = roomRepository.save(existingRoom);
            return roomDTOMapper.convertToDTO(savedRoom);
        }
        return null;
    }

    @Override
    public boolean deleteRoom(Integer id) {
        Optional<Room> optionalRoom=roomRepository.findById(id);
        if (optionalRoom.isPresent()){
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
