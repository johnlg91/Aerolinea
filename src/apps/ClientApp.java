package apps;

import impl.BasicServer;
import impl.PersistentServer;
import people.PersonClient;
import util.Scanner;

import static java.lang.System.out;

public class ClientApp  {

    public static void main(String[] args) {
        PersistentServer server = new PersistentServer("australis");
        Gui gui = new Gui(server);
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
        out.println("=     Bienvenidos a      =");
        out.println("= Aerolineas Australis   =");
        out.println("        ______\n" +
                "        _\\ _~-\\___\n" +
                "=  = ==(____AA____D\n" +
                "            \\_____\\___________________,-~~~~~~~`-.._\n" +
                "            /     o O o o o o O O o o o o o o O o  |\\_\n" +
                "            `~-.__        ___..----..                  )\n" +
                "                  `---~~\\___________/------------`````\n" +
                "                  =  ===(_________D");

        out.println("===========================");
        out.println("= s - Listar vuelos       =");
        out.println("= a - Comprar un pasaje   =");
        out.println("= d - Listar mis pasajes  =");
        out.println("===========================\n");
    }
}
