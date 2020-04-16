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
        return ticket;
    }
}
