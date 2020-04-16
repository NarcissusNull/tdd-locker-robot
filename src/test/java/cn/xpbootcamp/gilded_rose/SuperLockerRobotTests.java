package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperLockerRobotTests {
    @Test
    void should_get_ticket_when_save_given_there_is_place_in_super_locker_robot() {
        // given
        List<Locker> lockers = new ArrayList<Locker>();
        Locker locker1 = new Locker(2);
        locker1.save(new Bag());
        Locker locker2 = new Locker(3);
        locker2.save(new Bag());
        lockers.add(locker1);
        lockers.add(locker2);
        SuperLockerRobot superLockerRobot= new SuperLockerRobot(lockers);
        Bag bag = new Bag();

        // when
        Ticket ticket = superLockerRobot.save(bag);

        // then
        assertNotNull(ticket);
        assertEquals(bag, locker2.fetch(ticket));
    }
}