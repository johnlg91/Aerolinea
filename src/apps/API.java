package apps;

import air.*;
import ui.Scanner;

import java.util.Date;

import static java.lang.System.out;

public class API {
    public static void main(String[] args) {
        char cmd;
        do {
            printMenu();
            cmd = Scanner.getChar("Ingrese el comando o 'q' para salir\n");
            switch (cmd) {
                case 'A':

                    break;
                case 'P':

                    break;
                case 'C':

                    break;
                case 'q':
                    break;
                default:
                    out.println("Commando Invalido");
            }
        } while (cmd != 'q');
    }

    private static void printMenu() {
        out.println("======================================");
        out.println("======== Aerolineas Australis ========");
        out.println("======================================");
        out.println("= Admin - Ingresar como administrador =");
        out.println("= Piloto - Ingresar como Piloto =");
        out.println("= Cliete - Ingresar como cliente  =");
        out.println("======================================");
        out.println();
    }
}
