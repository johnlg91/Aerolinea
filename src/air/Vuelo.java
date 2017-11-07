package air;

import java.util.Date;
import java.util.Map;

public class Vuelo {

    private final Map<String,Seat> seats;
    private Date etd;
    private Date eta;
    private Plane plane;

    public String getCode() {
        return code;
    }

    private String code;
    private Aeropuerto departure;
    private Aeropuerto arrival;

    public Vuelo(String code, Plane plane, Aeropuerto departure, Aeropuerto arrival, Date etd, Date eta) {
        this.plane = plane;
        this.etd =etd;
        this.eta = eta;
        this.code = code;
        this.departure = departure;
        this.arrival = arrival;
        this.seats = plane.seats();
    }


    public Seat getSeat(String code) {
        return seats.get(code);
    }

    @Override
    public String toString() {
        return String.format("Vuelo: %5s %-10s ETD: %-30s  %-10s ETA: %-30s", code, departure, etd, arrival, eta);
    }

    public Iterable<Seat> getSeats() {
        return seats.values();
    }
}


