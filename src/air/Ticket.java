package air;

import people.PersonClient;

public class Ticket {
    private PersonClient personClient;
    private Vuelo vuelo;
    private Seat seat;
    private String ticketCode;

    public Ticket(PersonClient personClient, Vuelo vuelo, Seat seat) {
        this.vuelo = vuelo;
        this.seat = seat;
        this.personClient = personClient;
        ticketCode = seat.toString() + vuelo.toString();
    }
}
