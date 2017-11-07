package people;

public abstract class Empleado extends Persona {
    int DNI=super.DNI;
    String nombre=super.nombre;

    public Empleado(int DNI, String nombre) {
        super(DNI, nombre);
    }
}
