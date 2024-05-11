package com.arbahi.examsmanagement.service;

import com.arbahi.examsmanagement.dto.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomDTO> getAllRooms();

    Optional<RoomDTO> getRoomById(Integer id);

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO updateRoom(Integer id, RoomDTO updatedRoomDTO);

    boolean deleteRoom(Integer id);

}
