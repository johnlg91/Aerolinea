package people;

public abstract class Empleado extends People {

    int DNI = super.DNI;
    String nombre = super.name;

    public Empleado(int DNI, String nombre) {
        super(DNI, nombre);
    }
}
