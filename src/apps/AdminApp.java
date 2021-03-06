package apps;

import impl.PersistentServer;
import people.PersonClient;
import util.Scanner;

import static java.lang.System.out;

public class AdminApp {

    public static void main(String[] args) {
        PersistentServer server = new PersistentServer("australis");
        Gui gui = new Gui(server);
        char cmd;
        do {
            printMenu();
            cmd = Scanner.getChar("Ingrese el comando o 'q' para salir\n");
            switch (cmd) {
                case 'a':
                    gui.createFlight();
                    break;
                case 's':
                    PersonClient p = gui.checkClient();
                    gui.sellTicket(p);
                    break;
                case 'd':
                    gui.printFlights();
                    break;
                case 'f':
                    gui.createPlane();
                    break;
                case 'z':
                    gui.createAirport();
                    break;
                case 'x':
                    gui.printClients();
                    break;
                case 'c':
                    gui.createCliente();
                    break;
                case 'v':
                    gui.printAirports();
                    break;
                case 'q':
                    server.saveData();
                    break;
                default:
                    out.println("Commando Invalido\n");
            }
        } while (cmd != 'q');
    }

    private static void printMenu() {
        out.println("\n===============================");
        out.println("==   Aerolineas Australis    ==");
        out.println("===============================");
        out.println("= a - Registrar un vuelo      =");
        out.println("= s - Vender un pasaje        =");
        out.println("= d - Listar vuelos           =");
        out.println("= f - Registrar un avion      =");
        out.println("= z - Registrar un aeropuerto =");
        out.println("= x - Lista de clientes       =");
        out.println("= c - Registrar un cliente    =");
        out.println("= v - Listar aeropurtos       =");
        out.println("===============================\n");
    }
}
