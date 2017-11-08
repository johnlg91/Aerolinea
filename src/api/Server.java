package api;

import air.Airport;
import air.Flight;
import air.Plane;
import air.Seat;
import people.PersonClient;
import java.util.Date;

public interface Server {

    //Creators [
    void crearVuelo(String flightCode, String planeCode, Airport from, Airport to, Date etd, Date eta);

    void crearCliente(int dni, String nombre);

    void crearAvion(String planeCode, int rows, int cols);

    void crearAeropuerto(String name, int x, int y);
    // ]

    //Finders [
    Airport findAeropuerto(String code);

    Flight findVuelo(String flightCode);

    Plane findPlane(String code);

    Seat findSeat(String fligthCode, String seatCode);

    // ]

    //MapGetters [
    Iterable<String> getPlanesCodes();

    Iterable<Flight> getVuelosMap();

    Iterable<String> getAeropuertosNames();

    Iterable<PersonClient> getClientesMap();

    // ]

    void reserveSeat(String fligthCode, String seatCode);

    boolean isInPlaneKeySet(String key);

    boolean isInVueloKeySet(String key);

    boolean isInClienteKeySet(int dni);
}
