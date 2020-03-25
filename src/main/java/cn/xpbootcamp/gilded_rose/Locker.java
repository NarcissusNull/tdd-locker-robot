package cn.xpbootcamp.gilded_rose;

import java.util.UUID;

public class Locker {
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save() {
        this.capacity--;
        String id = UUID.randomUUID().toString();

        return new Ticket(id);
    }

    public int getCapacity() {
        return capacity;
    }
}
