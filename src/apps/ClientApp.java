package apps;

import impl.BasicServer;
import people.PersonClient;
import util.Scanner;

import static java.lang.System.out;

public class ClientApp  {

    public void clientApp() {
        Gui gui = new Gui(new BasicServer());
        PersonClient p = gui.checkClient();
        char cmd;
        do {
            printMenu();
            cmd = Scanner.getChar("Ingrese el comando o 'q' para salir\n");
            switch (cmd) {
                case 'a':
                    gui.sellTicket(p);
                    break;
                case 's':
                    gui.printFlights();
                    break;
                case 'd':
                    gui.printTickets(p);
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
        out.println("= d - Listar mis pasajes  =");
        out.println("=========================\n");
    }
}
