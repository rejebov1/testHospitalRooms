package by.elinext.booking.service.serviceImpl;

import by.elinext.booking.model.Room;
import by.elinext.booking.repository.RoomRepository;
import by.elinext.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "roomService")
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    @Transactional
    public void addRoom(Room room) {
        this.roomRepository.save(room);
    }

    @Override
    @Transactional
    public void removeRoom(Long id) {
        this.roomRepository.deleteById(id);
    }


    @Override
    @Transactional
    public Room getById(Long id) {
        return this.roomRepository.getOne(id);
    }

    @Override
    @Transactional
    public List<Room> roomList() {
        return this.roomRepository.findAll();
    }
}