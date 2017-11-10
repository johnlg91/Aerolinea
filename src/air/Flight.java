package air;

import java.util.Date;
import java.util.Map;

public class Flight {

    private final Map<String, Seat> seats;
    private final Map<String, Seat> seatsFirst;
    private Date etd;
    private Date eta;
    private Plane plane;
    private String code;
    private Airport departure;
    private Airport arrival;

    public Flight(String code, Plane plane, Airport departure, Airport arrival, Date etd, Date eta) {
        this.plane = plane;
        this.etd = etd;
        this.eta = eta;
        this.code = code;
        this.departure = departure;
        this.arrival = arrival;
        this.seats = plane.seats();
        this.seatsFirst = plane.seatsFirst();
    }

    public Seat getSeat(String code) {
        return seats.get(code);
    }

    public String getCode() {
        return code;
    }

    public Iterable<Seat> getSeats() {
        return seats.values();
    }

    public Iterable<Seat> getSeatsFirst() {
        return seatsFirst.values();
    }

    public Plane getPlane() {
        return plane;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public Date getETD() {
        return etd;
    }

    public Date getETA() {
        return eta;
    }

    @Override
    public String toString() {
        return String.format("Flight: %5s %-10s ETD: %-30s  %-10s ETA: %-30s\n", code, departure, etd, arrival, eta);
    }
}


