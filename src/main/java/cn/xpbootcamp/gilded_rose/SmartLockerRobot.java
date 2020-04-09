package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;
import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }


    public Ticket save(Bag bag) {
        Ticket ticket = lockers.stream().filter(e -> !e.isFull()).max(Comparator.comparing( Locker::getAvailableCapacity )).map(locker -> locker.save(bag)).orElse(null);
        if (ticket == null) {
            throw new RuntimeException("All lockers are full");
        }
        return ticket;
    }
}
