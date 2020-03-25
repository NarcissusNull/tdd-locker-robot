package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Locker {
    private int capacity;
    private List<Ticket> effectiveTickets = new ArrayList<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save() {
        if (this.capacity == 0) {
            return new Ticket(null, "There is no place to save.");
        }
        this.capacity--;
        String id = UUID.randomUUID().toString();

        Ticket ticket = new Ticket(id, "Save success");
        effectiveTickets.add(ticket);
        return ticket;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Ticket> getEffectiveTickets() {
        return this.effectiveTickets;
    }

    public boolean fetch(Ticket ticket) {
        if (effectiveTickets.contains(ticket)) {
            this.capacity++;
            effectiveTickets.remove(ticket);
            return true;
        } else {
            return false;
        }
    }
}
