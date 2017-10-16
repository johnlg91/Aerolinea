import cosasAeropuerto.Aeropuerto;

import java.util.Date;
import java.util.HashMap;

public class Vuelo {

    private final HashMap<String,Seat> seats;
    private Date etd;
    private Date eta;
    private Plane plane;
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



}
