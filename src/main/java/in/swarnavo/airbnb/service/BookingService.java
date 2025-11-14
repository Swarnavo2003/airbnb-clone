package in.swarnavo.airbnb.service;

import in.swarnavo.airbnb.dto.BookingDto;
import in.swarnavo.airbnb.dto.BookingRequest;
import in.swarnavo.airbnb.dto.GuestDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookingService {

    BookingDto initialize(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
