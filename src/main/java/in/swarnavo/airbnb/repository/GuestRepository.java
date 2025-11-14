package in.swarnavo.airbnb.repository;

import in.swarnavo.airbnb.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
