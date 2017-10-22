package apps;

import air.*;
import ui.Scanner;

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
                case 'l':
                    listarVuelos();
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
        Vuelo vuelo = new Vuelo("A", "737", Aeropuertos.getAustral(), Aeropuertos.getDitela(), etd, eta);
        Vuelos.add(vuelo);
        out.println("Vuelos: '" + vuelo.getCode() + "' creado.");
    }

    static void listarVuelos() {
        for (Vuelo v: Vuelos.list()) {
            out.println(v);
        }
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
        out.println("= l - lista de vuelos   =");
        out.println("= p - vender un pasaje  =");
        out.println("=========================");
        out.println();
    }
}
