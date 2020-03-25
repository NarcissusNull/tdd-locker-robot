package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
