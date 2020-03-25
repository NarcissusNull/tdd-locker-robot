package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTests {

    @Test
    void should_get_ticket_and_decrease_capacity_when_save_given_there_is_place_in_locker() {
        // given
        Locker locker = new Locker(20);

        // when
        Ticket ticket = locker.save();

        // then
        assertNotNull(ticket);
        assertEquals(19, locker.getCapacity());
    }

    @Test
    void should_get_full_ticket_when_save_given_there_is_no_place_in_locker() {
        // given
        Locker locker = new Locker(1);
        locker.save();

        // when
        Ticket ticket = locker.save();

        // then
        assertNotNull(ticket);
        assertNull(ticket.getId());
        assertEquals("There is no place to save.", ticket.getMessage());
    }
}
