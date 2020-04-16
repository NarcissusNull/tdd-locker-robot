package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;
import java.util.List;

public class SuperLockerRobot {
    private List<Locker> lockers;

    public SuperLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        Ticket ticket = lockers.stream().filter(e -> !e.isFull()).max(Comparator.comparing( Locker::getvacancyRate )).map(locker -> locker.save(bag)).orElse(null);
        if (ticket == null) {
            throw new RuntimeException("All lockers are full");
        }
        return ticket;
    }

    public Bag fetch(Ticket ticket) {
        Bag bag = lockers.stream().filter(e -> e.isActiveTicket(ticket)).findFirst().map(locker -> locker.fetch(ticket)).orElse(null);
        return bag;
    }
}
