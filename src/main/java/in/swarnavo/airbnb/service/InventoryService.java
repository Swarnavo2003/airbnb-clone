package in.swarnavo.airbnb.service;

import in.swarnavo.airbnb.entity.Room;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);
}
