//For managing available tickets and access
public class TicketPool {
    private int availableTickets;

    public TicketPool(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    //Allows for only one thread to reserve at a time
    public synchronized Ticket reserveTicket(String customerName) {
        //To check for available tickets
        while (availableTickets <= 0) {
            System.out.println(customerName + " tried to reserve but no tickets are left");
            return null;
        }
        //Reserve ticket
        availableTickets--;
        System.out.println(customerName + " has reserved a ticket with " + availableTickets + " tickets left");
        return new Ticket(availableTickets, "Festival");
    }
}
