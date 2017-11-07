package apps;

import air.Aeropuerto;
import air.Plane;
import air.Seat;
import air.Vuelo;
import api.Server;
import util.Scanner;

import java.util.Date;

import static java.lang.System.out;

public class Gui {
    private final Server server;

    public Gui(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }


    public Aeropuerto leerAeropuerto(String msg) {
        String airporCode = Scanner.getString(msg);
        Aeropuerto a = server.findAeropuerto(airporCode);
        if (a != null) return a;
        out.println("Codigo de aeropuerto incorrecto\n");
        return leerAeropuerto(msg);

    }

    public Vuelo leerVuelo() {
        Vuelo vuelo = server.findVuelo(Scanner.getString("Elija su vuelo\n"));
        if (vuelo != null) return vuelo;
        out.println("Vuelo no encontrado por favor seleccione otro");
        return leerVuelo();
    }

    public Plane leerAvion(String msg) {
        out.println(server.getPlanesCodes() + "\n");
        String planeCode = Scanner.getString(msg);
        Plane avion = server.findPlane(planeCode);
        if (avion != null) return avion;
        out.println("Avion no encontrado por favor seleccione otro");
        return leerAvion(msg);
    }


    //Metodos Print

    public void printVuelos() {
        for (Vuelo v : server.getVuelosMap()) {
            out.println(v);
        }
    }

    public void printSeats(Iterable<Seat> seats) {
        int row = 1;
        out.print("| ");
        for (Seat seat : seats) {
            if (seat.getRow() != row) {
                out.println("|");
                out.print("| ");
                row = seat.getRow();
            }
            if (seat.isReserved()) out.print("\033[31m" + seat + "\033[0m ");
            else out.print("\033[32m" + seat + "\033[0m ");
        }
        out.println("|\n");
    }


    //Metodos Create

    public void createVuelo() {
        String flightCode = Scanner.getString("Introdusca el codigo de vuelo\n");
        Date etd = Scanner.getDate("Introduzca su fecha de salida\n");
        Date eta = Scanner.getDate("Introduzca su fecha de llegada\n");
        Plane plane = leerAvion("Introduzca el tipo de Avion\n");
        Aeropuerto aeropuertoDesde = leerAeropuerto("Aeropuerto desde\n");
        Aeropuerto aeropuertoHasta = leerAeropuerto("Aeropuerto hasta\n");
        server.crearVuelo(flightCode, plane.getCode(), aeropuertoDesde, aeropuertoHasta, etd, eta);
        out.println("Vuelo: '" + flightCode + "' registrado.");
    }

    public void createAvion() {
        String planeCode = Scanner.getString("Intoduzca el codigo de Avion");
        if (server.isInPlaneKeySet(planeCode)) {
            out.println("Codigo de avion ya existente introduzca otro");
            createAvion();
        } else {
            int rows = Scanner.getInt("Introduzca la cantidad de filas");
            int columns = Scanner.getInt("Introduzca la cantidad de columnas");
            server.crearAvion(planeCode, rows, columns);
            out.println("El Avion '" + planeCode + "' a sido registrado.");
        }
    }


    public void createAeropuerto() {
        String name = Scanner.getString("Intoduzca el nombre del aeropuerto");
        if (server.isInPlaneKeySet(name)) {
            out.println("Aeropuerto ya existente introduzca otro");
            createAeropuerto();
        } else {
            int x = Scanner.getInt("Introduzca su ubicacion en el plano X");
            int y = Scanner.getInt("Introduzca su ubicacion en el plano Y");
            server.crearAeropuerto(name, x, y);
            out.println("El Avion '" + name + "' a sido registrado.");
        }
    }


    public void venderPasaje() {
        printVuelos();
        Vuelo vuelo = leerVuelo();
        printSeats(vuelo.getSeats());
        reservarSeat(vuelo.getCode());
    }

    public Seat reservarSeat(String fligthCode) {
        String seatCode = Scanner.getString("Elija su asiento\n");
        Seat s = server.findSeat(fligthCode, seatCode);
        if (s == null) {
            out.println("Asiento incorrecto por favor elija otro\n");
            return reservarSeat(fligthCode);
        }
        if (s.isReserved()) {
            out.println("El asiento que a eligio esta ocupado por favor elija otro\n");
            return reservarSeat(fligthCode);
        }
        server.reserveSeat(fligthCode, seatCode);
        out.println("Su asiento ha sido reservado\n ");
        out.println("Que tenga un buen día\n");
        return s;
    }
}
