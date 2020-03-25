package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Locker {
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save() {
        if (this.capacity == 0) {
            return new Ticket(null, "There is no place to save.");
        }

        this.capacity--;
        String id = UUID.randomUUID().toString();

        return new Ticket(id, "Save success");
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Ticket> getEffectiveTickets() {
        return new ArrayList<Ticket>();
    }

    public boolean fetch(Ticket ticket) {
        return false;
    }
}
