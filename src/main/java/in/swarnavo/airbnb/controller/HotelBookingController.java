package in.swarnavo.airbnb.controller;

import in.swarnavo.airbnb.dto.BookingDto;
import in.swarnavo.airbnb.dto.BookingRequest;
import in.swarnavo.airbnb.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/bookings")
public class HotelBookingController {

    private BookingService bookingService;

    @PostMapping("/init")
    public ResponseEntity<BookingDto> initializeBooking(@RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.initialize(bookingRequest));
    }
}
