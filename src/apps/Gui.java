package apps;

import air.*;
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


    //Callers, llaman al objeto desde server [

    public Airport callAirport(String msg) {
        Airport a = server.findAirport(msg);
        if (a != null) return a;
        out.println("Codigo de aeropuerto incorrecto\n");
        return callAirport(msg);

    }

    public Flight callFlight() {
        Flight flight = server.findFlight(Scanner.getString("Elija su flight\n"));
        if (flight != null) return flight;
        out.println("Flight no encontrado por favor seleccione otro");
        return callFlight();
    }

    public Plane callPlane(String msg) {
        out.println(server.getPlanesCodes() + "\n");
        String planeCode = Scanner.getString(msg);
        Plane avion = server.findPlane(planeCode);
        if (avion != null) return avion;
        out.println("Avion no encontrado por favor seleccione otro");
        return callPlane(msg);
    }

    // ]

    //Metodos Print

    public void printFlights() {
        for (Flight v : server.getFlightMap()) {
            out.println(v);
        }
    }

    public void printAirports() {
        for (String a : server.getAirportsNames())
            out.println(a);
    }

    //Corregirlo para q todos los dni terminen en la misma linea
    public void printClients() {
        for (PersonClient c : server.getClientMap()) {
            out.println("-------------------------------------");
            out.println(String.format("%-15s--------DNI: %-10s", c.getName(), c.getDNI()));
            out.println("-------------------------------------");
        }
    }

    public void printSeats(Iterable<Seat> seats, Iterable<Seat> seatsFirst) {
        out.print("---- Asientos de primera clase ----\n");
        out.println("");
        int rowFirstClass = 1;
        out.print("| ");
        for (Seat seat : seatsFirst) {
            if (seat.getRowFirstClass() != rowFirstClass) {
                out.println("|");
                out.print("| ");
                rowFirstClass = seat.getRowFirstClass();
            }
            if (seat.isReserved()) out.print("\033[31m" + seat + "\033[0m ");
            else {
                out.print("\033[32m" + seat + "\033[0m ");
            }
        }
        out.println("|");
        out.print("\n---- Asientos de clase media ----\n");
        out.println("");
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

    public void printTickets(PersonClient p) {
        for (Ticket t : p.getReserves()) {
            out.println(t);
        }
    }


    // ]


    //Metodos Create [

    public void createFlight() {
        String flightCode = Scanner.getString("Introdusca un nuevo codigo de vuelo\n");
        if (server.isInFlightKeySet(flightCode)) {
            out.println("Codigo de vuelo ya existente iroduzca otro\n");
            createFlight();
        } else {
            Date etd = Scanner.getDate("Introduzca su fecha de salida\n");
            Date eta = Scanner.getDate("Introduzca su fecha de llegada\n");
            out.println("Codigo de aviones disponibles: ");
            Plane plane = callPlane("Introduzca el codigo de un Avion\n");
            out.println("------------------Aeropuertos----------------");
            printAirports();
            out.println("---------------------------------------------");
            String airportName = Scanner.getString("Airport desde\n");
            Airport airportDesde = callAirport(airportName);
            out.println("------------------Aeropuertos----------------");
            printAirports();
            out.println("---------------------------------------------");
            String airportName2 = Scanner.getString("Airport hasta\n");
            if (airportName.equals(airportName2)) createFlight();
            else {
                Airport airportHasta = callAirport(airportName2);
                server.crearFlight(flightCode, plane.getCode(), airportDesde, airportHasta, etd, eta);
                out.println("Flight: '" + flightCode + "' registrado.");
            }
        }
    }

    public void createPlane() {
        String planeCode = Scanner.getString("Cree un codigo para el Avion: ");
        if (server.isInPlaneKeySet(planeCode)) {
            out.println("Codigo de avion ya existente introduzca otro: ");
            createPlane();
        } else {
            int rowsFirstClass = Scanner.getInt("Introduzca la cantidad de filas para primera clase: ");
            int rows = Scanner.getInt("Introduzca la cantidad de filas para clase media: ");
            int columns = Scanner.getInt("Introduzca la cantidad de columnas: ");
            server.crearPlane(planeCode, rowsFirstClass, rows, columns);
            out.println("El Avion '" + planeCode + "' a sido registrado.");
        }
    }


    public void createAirport() {
        String name = Scanner.getString("Intoduzca el nombre del aeropuerto");
        if (server.isInPlaneKeySet(name)) {
            out.println("Airport ya existente introduzca otro\n");
            createAirport();
        } else {
            int x = Scanner.getInt("Introduzca su ubicacion en el plano X\n");
            int y = Scanner.getInt("Introduzca su ubicacion en el plano Y\n");
            server.crearAeropuerto(name, x, y);
            out.println("El Avion '" + name + "' a sido registrado.");
        }
    }

    public void createCliente() {
        int DNI = Scanner.getInt("Introduzca su DNI\n");
        if (server.isInClientKeySet(DNI)) {
            out.println("El usuario ya esta registrado\n");
        } else {
            String name = Scanner.getString("Introduzca su nombre\n");
            server.crearClient(DNI, name);
        }
    }

    // ]


    public void sellTicket(PersonClient p) {
        printFlights();
        Flight flight = callFlight();
        printSeats(flight.getSeats(), flight.getSeatsFirst());
        reserveSeat(flight.getCode(), p);
    }

    public Seat reserveSeat(String fligthCode, PersonClient p) {
        String seatCode = Scanner.getString("Elija su asiento\n").toUpperCase();
        Seat s = server.findSeat(fligthCode, seatCode);
        if (s == null) {
            out.println("Asiento incorrecto por favor elija otro\n");
            return reserveSeat(fligthCode, p);
        }
        if (s.isReserved()) {
            out.println("El asiento que a eligio esta ocupado por favor elija otro\n");
            return reserveSeat(fligthCode, p);
        }
        server.reserveSeat(fligthCode, seatCode, p.getDNI());
        out.println("Su asiento ha sido reservado.\n ");
        char macarena = Scanner.getChar("Introduzca 'y' para reservar otro asiento.\n" +
                "Intoduzca 'n' para finalizar la reserva.\n");
        switch (macarena) {
            case 'y':
                sellTicket(p);
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

    public PersonClient checkClient() {
        int DNI = Scanner.getInt("Introduzca su DNI\n");
        String name = Scanner.getString("Introduzca su nombre\n");
        if (server.isInClientKeySet(DNI)) {
            return server.findClient(DNI);
        } else {
            out.println("Usuario no registrado,tiene q registrarse para relaizar una compra, desea registrarse?");
            char macarena = Scanner.getChar("Introduzca 'y' o 'n'\n");
            switch (macarena) {
                case 'y':
                    server.crearClient(DNI, name);
                    return server.findClient(DNI);
                case 'n':
                    out.println("Que tenga un buen día\n");
                    break;
                default:
                    out.println("Commando Invalido\n");
                    checkClient();
                    break;
            }
        }
        return null;
    }
}
