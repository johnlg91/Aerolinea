package people;

import java.util.Scanner;

public abstract class Persona {

    public Persona(int DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    protected int DNI;
    protected String nombre;

}
