package in.swarnavo.airbnb.dto;

import in.swarnavo.airbnb.entity.Hotel;
import in.swarnavo.airbnb.entity.Room;
import in.swarnavo.airbnb.entity.User;
import in.swarnavo.airbnb.entity.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDto {
    private Long id;
    private Integer roomsCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;
}
