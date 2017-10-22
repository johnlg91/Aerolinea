package air;

import java.util.Date;
import java.util.TreeMap;

public class Vuelo {

    private final TreeMap<String,Seat> seats;
    private Date etd;
    private Date eta;
    private Plane plane;

    public String getCode() {
        return code;
    }

    private String code;
    private Aeropuerto departure;
    private Aeropuerto arrival;

    public Vuelo(String code, String planeCode, Aeropuerto departure, Aeropuerto arrival, Date etd, Date eta) {
        plane = Planes.findPlane(planeCode);
        this.etd =etd;
        this.eta = eta;
        this.code = code;
        this.departure = departure;
        this.arrival = arrival;
        this.seats = plane.seats();
    }

    public void printSeats() {
        int row = 1;
        for (Seat seat : seats.values()) {
            if (seat.getRow() != row) {
                System.out.println();
                row = seat.getRow();
            }
            System.out.print(seat);
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return String.format("Vuelo: %5s %-10s ETD: %-30s  %-10s ETA: %-30s", code, departure, etd, arrival, eta);
    }
}


