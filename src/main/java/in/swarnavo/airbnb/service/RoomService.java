package in.swarnavo.airbnb.service;

import in.swarnavo.airbnb.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto createNewRoom(Long hotelId, RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);

    RoomDto getSingleRoomById(Long roomId);

    void deleteRoomById(Long roomId);
}
