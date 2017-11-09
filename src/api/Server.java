package api;

import air.Airport;
import air.Flight;
import air.Plane;
import air.Seat;
import people.PersonClient;
import java.util.Date;

public interface Server {

    //Creators [
    void crearFlight(String flightCode, String planeCode, Airport from, Airport to, Date etd, Date eta);

    void crearClient(int dni, String nombre);

    void crearPlane(String planeCode, int rows, int cols);

    void crearAeropuerto(String name, int x, int y);
    // ]

    //Finders [
    Airport findAirport(String code);

    Flight findFlight(String flightCode);

    Plane findPlane(String code);

    Seat findSeat(String fligthCode, String seatCode);

    // ]

    //MapGetters [
    Iterable<String> getPlanesCodes();

    Iterable<Flight> getFlightMap();

    Iterable<String> getAirportsNames();

    Iterable<PersonClient> getClientMap();

    // ]

    void reserveSeat(String fligthCode, String seatCode);

    boolean isInPlaneKeySet(String key);

    boolean isInFlightKeySet(String key);

    boolean isInClientKeySet(int dni);
}
