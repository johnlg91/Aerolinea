package people;

import air.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends People {


    private List<Ticket> tickets = new ArrayList<>();


    public Cliente(int DNI, String nombre) {
        super(DNI, nombre);
    }

    public String getName() {
        return name;
    }

    public int getDNI() {
        return DNI;
    }
}
