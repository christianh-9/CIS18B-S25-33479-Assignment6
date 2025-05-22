//Class for representing a reserved ticket
public class Ticket {
    private final int id;
    private final String event;

    public Ticket(int id, String event) {
        this.id = id;
        this.event = event;
    }
    //Getters for private class variables
    public int getId() {
        return id;
    }
    public String getEvent() {
        return event;
    }
}
