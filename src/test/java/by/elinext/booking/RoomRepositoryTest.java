package by.elinext.booking;

import by.elinext.booking.model.Room;
import by.elinext.booking.repository.RoomRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void isDataSavingToDb() {
        Room room = Room.builder()
                .description("Procedure")
                .localTime(LocalDateTime.now())
                .user("Doctor")
                .build();

        roomRepository.save(room);

        Assertions.assertEquals("Procedure", room.getDescription());
        Assertions.assertEquals("Doctor", room.getUser());
    }
}
