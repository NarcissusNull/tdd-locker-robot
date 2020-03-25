package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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


    @Test
    void should_ticker_not_work_and_capacity_plus_one_when_fetch_given_a_effective_ticket() {
        // given
        Locker locker = new Locker(20);
        Ticket ticket = locker.save();

        // when
        boolean status = locker.fetch(ticket);

        // then
        assertTrue(status);
        assertFalse(locker.getEffectiveTickets().contains(ticket));
        assertEquals(20, locker.getCapacity());
    }

    @Test
    void should_prompt_ticker_not_work_when_fetch_given_a_not_work_ticket() {
        // given
        Locker locker = new Locker(20);
        Ticket ticket = locker.save();
        locker.fetch(ticket);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        boolean status = locker.fetch(ticket);
        // then
        assertFalse(status);
        assertEquals("ticket not work", outContent.toString());
    }
}
