package cn.xpbootcamp.gilded_rose;

import java.util.List;

public class PrimaryLockerRobot {

    private List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        return lockers.stream().filter(e -> !e.isFull()).findFirst().map(locker -> locker.save(bag)).orElse(null);
    }
}
