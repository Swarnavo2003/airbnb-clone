package in.swarnavo.airbnb.service;

import in.swarnavo.airbnb.dto.BookingDto;
import in.swarnavo.airbnb.dto.BookingRequest;
import org.springframework.stereotype.Service;

public interface BookingService {

    BookingDto initialize(BookingRequest bookingRequest);
}
