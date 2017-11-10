package people;

abstract class PersonEmployee extends Person {

    int DNI = super.DNI;
    String nombre = super.name;

    PersonEmployee(int DNI, String nombre) {
        super(DNI, nombre);
    }
}
