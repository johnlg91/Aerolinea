package air;

import people.Cliente;

public class Ticket {
    private Cliente cliente;
    private Vuelo vuelo;
    private Seat seat;
    private String ticketCode;

    public Ticket(Cliente cliente, Vuelo vuelo, Seat seat) {
        this.vuelo = vuelo;
        this.seat = seat;
        this.cliente = cliente;
        ticketCode = seat.toString() + vuelo.toString();
    }
}
