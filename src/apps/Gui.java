package apps;

import air.Airport;
import air.Plane;
import air.Seat;
import air.Vuelo;
import api.Server;
import people.PersonClient;
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


    //Lectores, verifican q el objeto exista [

    public Airport leerAeropuerto(String msg) {
        String airporCode = Scanner.getString(msg);
        Airport a = server.findAeropuerto(airporCode);
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

    // ]

    //Metodos Print

    public void printVuelos() {
        for (Vuelo v : server.getVuelosMap()) {
            out.println(v);
        }
    }

    public void printAeropuertos() {
        for (String a : server.getAeropuertosNames())
            out.println(a);
    }

    //Corregirlo para q todos los dni terminen en la misma linea
    public void printClientes() {
        for (PersonClient c : server.getClientesMap()) {
            out.println(c.getName() + "_______" + c.getDNI());
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


    // ]


    //Metodos Create [

    public void createVuelo() {
        String flightCode = Scanner.getString("Introdusca el codigo de vuelo\n");
        if (server.isInVueloKeySet(flightCode)) {
            out.println("Codigo de vuelo ya existente iroduzca otro\n");
            createVuelo();
        } else {
            Date etd = Scanner.getDate("Introduzca su fecha de salida\n");
            Date eta = Scanner.getDate("Introduzca su fecha de llegada\n");
            Plane plane = leerAvion("Introduzca el tipo de Avion\n");
            Airport airportDesde = leerAeropuerto("Airport desde\n");
            Airport airportHasta = leerAeropuerto("Airport hasta\n");
            server.crearVuelo(flightCode, plane.getCode(), airportDesde, airportHasta, etd, eta);
            out.println("Vuelo: '" + flightCode + "' registrado.");
        }
    }

    public void createAvion() {
        String planeCode = Scanner.getString("Cree un codigo para el Avion");
        if (server.isInPlaneKeySet(planeCode)) {
            out.println("Codigo de avion ya existente introduzca otro\n");
            createAvion();
        } else {
            int rows = Scanner.getInt("Introduzca la cantidad de filas");
            int columns = Scanner.getInt("Introduzca la cantidad de columnas");
            server.crearAvion(planeCode, rows, columns);
            out.println("El Avion '" + planeCode + "' a sido registrado.");
        }
    }


    public void createAeropuerto() {
        String name = Scanner.getString("Intoduzca el name del aeropuerto");
        if (server.isInPlaneKeySet(name)) {
            out.println("Airport ya existente introduzca otro");
            createAeropuerto();
        } else {
            int x = Scanner.getInt("Introduzca su ubicacion en el plano X");
            int y = Scanner.getInt("Introduzca su ubicacion en el plano Y");
            server.crearAeropuerto(name, x, y);
            out.println("El Avion '" + name + "' a sido registrado.");
        }
    }

    public void createCliente() {
        int DNI = Scanner.getInt("Introduzca su DNI");
        if (server.isInClienteKeySet(DNI)) {
            out.println("El usuario ya esta registrado");
        } else {
            String name = Scanner.getString("Introduzca su name");
            server.crearCliente(DNI, name);
        }
    }

    // ]


    public void sellTicket() {
        printVuelos();
        Vuelo vuelo = leerVuelo();
        printSeats(vuelo.getSeats());
        reserveSeat(vuelo.getCode());
    }

    public Seat reserveSeat(String fligthCode) {
        String seatCode = Scanner.getString("Elija su asiento\n");
        Seat s = server.findSeat(fligthCode, seatCode);
        if (s == null) {
            out.println("Asiento incorrecto por favor elija otro\n");
            return reserveSeat(fligthCode);
        }
        if (s.isReserved()) {
            out.println("El asiento que a eligio esta ocupado por favor elija otro\n");
            return reserveSeat(fligthCode);
        }
        server.reserveSeat(fligthCode, seatCode);
        out.println("Su asiento ha sido reservado\n ");
        char macarena = Scanner.getChar("Introduzca 'y' para reservar otro asiento.\n" +
                "Intoduzca 'n' para finalizar la reserva.\n");
        switch (macarena) {
            case 'y':
                sellTicket();
                break;
            case 'n':
                out.println("Que tenga un buen día\n");
                break;
            default:
                out.println("Commando Invalido\n");
                break;
        }
        return s;
    }


}
