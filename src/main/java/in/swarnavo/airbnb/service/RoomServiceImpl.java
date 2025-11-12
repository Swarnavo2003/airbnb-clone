package in.swarnavo.airbnb.service;

import in.swarnavo.airbnb.dto.RoomDto;
import in.swarnavo.airbnb.entity.Hotel;
import in.swarnavo.airbnb.entity.Room;
import in.swarnavo.airbnb.exception.ResourceNotFoundException;
import in.swarnavo.airbnb.repository.HotelRepository;
import in.swarnavo.airbnb.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        log.info("Creating a new room in hostel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID : " + hotelId));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

        // TODO: create room inventory as soon as room is created and hotel is active

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        return List.of();
    }

    @Override
    public RoomDto getSingleRoomById(Long roomId) {
        return null;
    }

    @Override
    public void deleteRoomById(Long roomId) {

    }
}
