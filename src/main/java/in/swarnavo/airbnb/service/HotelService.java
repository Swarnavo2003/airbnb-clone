package in.swarnavo.airbnb.service;

import in.swarnavo.airbnb.dto.HotelDto;
import in.swarnavo.airbnb.dto.HotelInfoDto;

public interface HotelService {
    HotelDto createHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id, HotelDto hotelDto);
    Boolean deleteHotelById(Long id);
    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
