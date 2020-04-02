package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PrimaryLockerRobotTests {
    @Test
    void should_get_ticket_when_save_given_there_is_place_in_primary_locker_robot() {
        // given
        List<Locker> lockers = new ArrayList<Locker>();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(0);
        lockers.add(locker1);
        lockers.add(locker2);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag();

        // when
        Ticket ticket = primaryLockerRobot.save(bag);

        // then
        assertNotNull(ticket);
    }
}
