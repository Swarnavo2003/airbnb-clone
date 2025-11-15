package in.swarnavo.airbnb.service;

import in.swarnavo.airbnb.dto.HotelDto;
import in.swarnavo.airbnb.dto.HotelPriceDto;
import in.swarnavo.airbnb.dto.HotelSearchRequest;
import in.swarnavo.airbnb.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
