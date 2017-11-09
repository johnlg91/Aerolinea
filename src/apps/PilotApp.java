package apps;

import impl.BasicServer;
import util.Scanner;

import static java.lang.System.out;


public class PilotApp {

    public static void main(String[] args) {
        Gui gui = new Gui(new BasicServer());

        char cmd;
        do {
            printMenu();
            cmd = Scanner.getChar("Ingrese el comando o 'q' para salir\n");
            switch (cmd) {
                case 'a':
                    //getrecordList();
                    break;
                case 'q':
                    break;
                default:
                    out.println("Commando Invalido\n");
            }
        } while (cmd != 'q');
    }

    private static void printMenu() {
        out.println("\n==================================");
        out.println("====== Aerolineas Australis   ======");
        out.println("====================================");
        out.println("= a - abrir registro de itinerario =");
        out.println("====================================\n");
    }

}
