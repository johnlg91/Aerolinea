package apps;

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
                    gui.printVuelos();
                    break;
                case 'd':
                    //get.reservas
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
        out.println("= a - Listar vuelos      =");
        out.println("= s - Comprar un pasaje  =");
        out.println("= d - Listar mis vuelos  =");
        out.println("=========================\n");
    }
}
