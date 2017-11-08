package apps;

import api.Server;
import impl.BasicServer;
import util.Scanner;

import static java.lang.System.out;

public class ClientApp {

    public static void main(String[] args) {
        Gui gui = new Gui(new BasicServer());
        char cmd;
        do {
            printMenu();
            cmd = Scanner.getChar("Ingrese el comando o 'q' para salir\n");
            switch (cmd) {
                case 'a':
                    gui.sellTicket();
                    break;
                case 's':
                    gui.printFlights();
                    break;
                case 'd':
                    //getreservs();
                    break;
                case 'q':
                    break;
                default:
                    out.println("Commando Invalido\n");
            }
        } while (cmd != 'q');
    }


    private static void printMenu() {
        out.println("\n==========================");
        out.println("= Aerolineas Australis   =");
        out.println("==========================");
        out.println("= s - Listar vuelos      =");
        out.println("= a - Comprar un pasaje  =");
        out.println("= d - Listar mis vuelos  =");
        out.println("=========================\n");
    }
}
