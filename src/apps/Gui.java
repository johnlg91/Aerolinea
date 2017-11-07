package apps;

import air.*;
import api.Server;
import util.Scanner;

import java.util.Date;

import static java.lang.System.out;

public class Gui {
    private final Server server;

    public Gui(Server server) {
        this.server = server;
    }

    public void imprimirVuelos() {
        for (Vuelo v : server.listVuelos()) {
            out.println(v);
        }
    }

    public Vuelo leerVuelo() {
        Vuelo vuelo = server.findVuelo(Scanner.getString("Elija su vuelo\n"));
        if (vuelo != null) return vuelo;
        out.println("Vuelo no encontrado por favor seleccione otro");
        return leerVuelo();
    }

    public Plane leerAvion(String msg) {
        out.println(server.getPlanes() + "\n");
        String planeCode = Scanner.getString(msg);
        Plane avion = server.findPlane(planeCode);
        if (avion != null) return avion;
        out.println("Avion no encontrado por favor seleccione otro");
        return leerAvion(msg);
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

    public void printSeats(Iterable<Seat> seats) {
        int row = 1;
        out.print("| ");
        for (Seat seat : seats) {
            if (seat.getRow() != row) {
                out.println("|");
                out.print("| ");
                row = seat.getRow();
            }
            if (seat.isReserved()) out.print("\033[31m"+seat+"\033[0m ");
            else out.print("\033[32m"+seat+"\033[0m ");
        }
        out.println("|\n");
    }

    public Aeropuerto leerAeropuerto(String msg) {
        String airporCode = Scanner.getString(msg);
        Aeropuerto a = server.findAeropuerto(airporCode);
        if (a != null) return a;
        out.println("Codigo de aeropuerto incorrecto\n");
        return leerAeropuerto(msg);

    }

    public Server getServer() {
        return server;
    }

    public void crearVuelo() {
        String flightCode = Scanner.getString("Introdusca el codigo de vuelo\n");
        Date etd = Scanner.getDate("Introduzca su fecha de salida\n");
        Date eta = Scanner.getDate("Introduzca su fecha de llegada\n");
        Plane plane = leerAvion("Introduzca el tipo de Avion\n");
        Aeropuerto aeropuertoDesde = leerAeropuerto("Aeropuerto desde\n");
        Aeropuerto aeropuertoHasta = leerAeropuerto("Aeropuerto hasta\n");
        Vuelo vuelo = server.crearVuelo(flightCode, plane.getCode(), aeropuertoDesde, aeropuertoHasta, etd, eta);
        out.println("Vuelo: '" + vuelo.getCode() + "' creado.");
    }

    public void crearAvion() {

    }

    public void crearAeropuerto() {

    }


    public void venderPasaje() {
        imprimirVuelos();
        Vuelo vuelo = leerVuelo();
        printSeats(vuelo.getSeats());
        reservarSeat(vuelo.getCode());
    }


}
