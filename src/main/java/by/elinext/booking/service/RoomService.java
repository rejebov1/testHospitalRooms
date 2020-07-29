package by.elinext.booking.service;

import by.elinext.booking.model.Room;

import java.util.List;

public interface RoomService {

    void addRoom(Room room);

    void removeRoom(Long id);

    Room getById(Long id);

    List<Room> roomList();
}