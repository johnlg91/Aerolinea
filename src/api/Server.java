package api;

import air.Aeropuerto;
import air.Plane;
import air.Seat;
import air.Vuelo;
import people.Cliente;
import java.util.Date;

public interface Server {

    //Creators [
    void crearVuelo(String flightCode, String planeCode, Aeropuerto from, Aeropuerto to, Date etd, Date eta);

    void crearCliente(int dni, String nombre);

    void crearAvion(String planeCode, int rows, int cols);

    void crearAeropuerto(String name, int x, int y);
    // ]

    //Finders [
    Aeropuerto findAeropuerto(String code);

    Vuelo findVuelo(String flightCode);

    Plane findPlane(String code);

    Seat findSeat(String fligthCode, String seatCode);

    // ]

    //MapGetters [
    Iterable<String> getPlanesCodes();

    Iterable<Vuelo> getVuelosMap();

    Iterable<String> getAeropuertosNames();

    Iterable<Cliente> getClientesMap();

    // ]

    void reserveSeat(String fligthCode, String seatCode);

    boolean isInPlaneKeySet(String key);

    boolean isInVueloKeySet(String key);

    boolean isInClienteKeySet(int dni);
}