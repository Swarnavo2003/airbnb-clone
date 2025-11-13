package in.swarnavo.airbnb.repository;

import in.swarnavo.airbnb.entity.Inventory;
import in.swarnavo.airbnb.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByRoom(Room room);

}
