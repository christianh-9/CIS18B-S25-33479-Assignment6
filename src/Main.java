import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Customer class for trying to reserve a ticket
class Customer implements Runnable {
    private String customerName;
    private TicketPool pool;

    public Customer(String n, TicketPool p) {
        this.customerName = n;
        this.pool = p;
    }

    // For each customer wanting to reserve a ticket
    public void run() {
        Ticket ticket = pool.reserveTicket(customerName);
        if (ticket != null) {
            System.out.println(customerName + " reserved ticket #" + (ticket.getId() +1) + " for " + ticket.getEvent());
        }
    }
}

public class Main {
    public static void main(String args[]) {

        //Allow 5 available tickets
        TicketPool pool = new TicketPool(5);

        //Virtual thread executor
        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {
            //8 customers each trying to get one of 5 tickets
            for (int i = 1; i <= 8; i++) {
                String name = "Customer " + i;
                exec.submit(new Customer(name, pool)); //Separate virtual threads
            }
        }
    }
}