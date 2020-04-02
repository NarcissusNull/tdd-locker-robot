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
}
