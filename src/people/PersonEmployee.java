package people;

public abstract class PersonEmployee extends Person {

    int DNI = super.DNI;
    String nombre = super.name;

    public PersonEmployee(int DNI, String nombre) {
        super(DNI, nombre);
    }
}
