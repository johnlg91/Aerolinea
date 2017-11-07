package people;

import java.util.Scanner;

public abstract class Persona {

    protected int DNI;
    protected String nombre;

    public Persona(int DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }


}
