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
        Bag bag = new Bag();

        // when
        Ticket ticket = locker.save(bag);

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_get_full_ticket_when_save_given_there_is_no_place_in_locker() {
        // given
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        locker.save(bag);

        // when
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> locker.save(bag));
        // then
        assertEquals("locker is empty", runtimeException.getMessage());
    }


    @Test
    void should_ticker_not_work_and_capacity_plus_one_when_fetch_given_a_effective_ticket() {
        // given
        Locker locker = new Locker(20);
        Bag bag = new Bag();
        Ticket ticket = locker.save(bag);

        // when
        Bag fetchedBag = locker.fetch(ticket);

        // then
        assertEquals(bag, fetchedBag);
    }

    @Test
    void should_prompt_ticker_not_work_when_fetch_given_a_not_work_ticket() {
        // given
        Locker locker = new Locker(20);
        Bag bag = new Bag();
        Ticket ticket = locker.save(bag);
        locker.fetch(ticket);

        // when
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> locker.fetch(ticket));


        // then
        assertEquals("ticket not work", runtimeException.getMessage());

    }
}
