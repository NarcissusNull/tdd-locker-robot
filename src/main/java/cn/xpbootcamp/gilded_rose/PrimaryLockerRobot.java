package cn.xpbootcamp.gilded_rose;

import java.util.List;

public class PrimaryLockerRobot {

    private List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        Ticket ticket = lockers.stream().filter(e -> !e.isFull()).findFirst().map(locker -> locker.save(bag)).orElse(null);
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
