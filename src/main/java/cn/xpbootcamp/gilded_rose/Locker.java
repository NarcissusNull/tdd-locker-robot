package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Locker {
    private int capacity;
    private Map<Ticket, Bag> usedCapacity = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == usedCapacity.size();
    }

    public Ticket save(Bag bag) {
        if (this.usedCapacity.size() >= this.capacity) {
            throw new RuntimeException("locker is empty");
        }

        String id = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(id);
        usedCapacity.put(ticket, bag);

        return ticket;
    }

    public boolean isActiveTicket(Ticket ticket) {
        return usedCapacity.containsKey(ticket);
    }

    public Bag fetch(Ticket ticket) {
        if (!isActiveTicket(ticket)) {
            throw new RuntimeException("ticket not work");
        }

        Bag bag = usedCapacity.get(ticket);
        usedCapacity.remove(ticket);
        return bag;
    }

    public int getAvailableCapacity() {
        return capacity - usedCapacity.size();
    }

    public double getvacancyRate() {
        return 1 - this.usedCapacity.size() / (double) this.capacity;
    }
}
