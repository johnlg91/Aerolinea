package air;

import people.PersonClient;

public class Ticket {
    private PersonClient personClient;
    private Flight flight;
    private Seat seat;
    private String ticketCode;

    public Ticket(PersonClient personClient, Flight flight, Seat seat) {
        this.flight = flight;
        this.seat = seat;
        this.personClient = personClient;
        ticketCode = seat.toString() + flight.toString();
    }
}
