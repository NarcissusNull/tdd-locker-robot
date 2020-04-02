package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_get_full_exception_when_save_given_there_is_no_place_in_robot() {
        // given
        List<Locker> lockers = new ArrayList<Locker>();
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(0);
        lockers.add(locker1);
        lockers.add(locker2);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag();

        // when
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> primaryLockerRobot.save(bag));
        // then
        assertEquals("All lockers are full", runtimeException.getMessage());
    }


    @Test
    void should_get_bag_when_fetch_given_a_effective_ticket() {
        // given
        List<Locker> lockers = new ArrayList<Locker>();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(0);
        lockers.add(locker1);
        lockers.add(locker2);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);

        // when
        Bag fetchedBag = primaryLockerRobot.fetch(ticket);

        // then
        assertEquals(bag, fetchedBag);
    }

    @Test
    void should_get_ticket_not_work_exception_when_fetch_given_not_work_ticket() {
        // given
        List<Locker> lockers = new ArrayList<Locker>();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(0);
        lockers.add(locker1);
        lockers.add(locker2);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);
        primaryLockerRobot.fetch(ticket);

        // when
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> primaryLockerRobot.fetch(ticket));


        // then
        assertEquals("ticket not work", runtimeException.getMessage());

    }

}
