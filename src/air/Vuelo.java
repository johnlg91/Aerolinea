package air;

import java.util.Date;
import java.util.Map;

public class Vuelo {

    private final Map<String, Seat> seats;
    private Date etd;
    private Date eta;
    private Plane plane;
    private String code;
    private Airport departure;
    private Airport arrival;

    public Vuelo(String code, Plane plane, Airport departure, Airport arrival, Date etd, Date eta) {
        this.plane = plane;
        this.etd = etd;
        this.eta = eta;
        this.code = code;
        this.departure = departure;
        this.arrival = arrival;
        this.seats = plane.seats();
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

    @Override
    public String toString() {
        return String.format("Vuelo: %5s %-10s ETD: %-30s  %-10s ETA: %-30s\n", code, departure, etd, arrival, eta);
    }
}


