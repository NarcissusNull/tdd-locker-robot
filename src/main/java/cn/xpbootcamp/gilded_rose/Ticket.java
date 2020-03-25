package cn.xpbootcamp.gilded_rose;

public class Ticket {
    private String id;
    private String message;

    public Ticket(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return this.message;
    }
}
