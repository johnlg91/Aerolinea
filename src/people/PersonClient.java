package people;

import air.Ticket;

import java.util.ArrayList;
import java.util.List;

public class PersonClient extends Person {

    private List<Ticket> tickets = new ArrayList<>();

    public PersonClient(int DNI, String name) {
        super(DNI, name);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Iterable<Ticket> getReserves() {
        return tickets;
    }

    public String getName() {
        return name;
    }

    public int getDNI() {
        return DNI;
    }

}
