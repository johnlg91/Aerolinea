package apps;

import air.Aeropuertos;
import air.Seat;
import air.Vuelo;
import ui.Scanner;
import air.Vuelos;

import java.util.Date;

import static java.lang.System.out;

public class Aerolinea {
    public static void main(String[] args) {
        int cmd;
        do {
            printMenu();
            cmd = Scanner.getChar("Ingrese el comando o 'q' para salir\n");
            switch (cmd) {
                case 'v':
                    crearVuelo();
                    break;
                case 'p':
                    venderPasaje();
                    break;
                case 'q':
                    break;
                default:
                    out.println("Commando Invalido");
            }
        } while (cmd != 'q');
    }

    static void crearVuelo() {
        Date etd = Scanner.getDate("Introduzca su fecha de salida\n");
        Date eta = Scanner.getDate("Introduzca su fecha de llegada\n");
        Vuelo a = new Vuelo("A", "737", Aeropuertos.getAustral(), Aeropuertos.getDitela(), etd, eta);
        Vuelos.add(a);
    }

    static void venderPasaje() {

        //a.printSeats()
        //Seat reserved = Scanner.getString("Elija su asiento");

    }

    static void printMenu() {
        out.println("=========================");
        out.println("= Aerolineas Australis  =");
        out.println("=========================");
        out.println("= v - crear un vuelo    =");
        out.println("= p - vender un pasaje  =");
        out.println("=========================");
        out.println();
    }
}
