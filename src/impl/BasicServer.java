package impl;

import air.*;
import api.Server;
import people.PersonClient;
import java.util.Date;
import java.util.TreeMap;

public class BasicServer implements Server {

    // Aeropuertos guardados en mapa
    private TreeMap<String, Aeropuerto> aeropuertosMap = new TreeMap<>();

    // Vuelos Guardados en mapa
    private TreeMap<String, Vuelo> vuelosMap = new TreeMap<>();

    // Aviones Guardados en mapa
    private TreeMap<String, Plane> planesMap = new TreeMap<>();

    // Clientes Guardados en mapa
    private TreeMap<Integer, PersonClient> clientesMap = new TreeMap<>();

    // Tickets Guardados en mapa
    private TreeMap<String, Ticket> ticketMap = new TreeMap<>();


    //Getters para para los los keys o valores de los mapas [

    public Iterable<String> getPlanesCodes() {
        return planesMap.keySet();
    }

    @Override
    public Iterable<Vuelo> getVuelosMap() {
        return vuelosMap.values();
    }

    @Override
    public Iterable<String> getAeropuertosNames() {
        return aeropuertosMap.keySet();
    }

    @Override
    public Iterable<PersonClient> getClientesMap() {
        return clientesMap.values();
    }

    // ]


    //Finders, retornan lo desado del mapa segun el codigo String pasado [
    public Plane findPlane(String code) {
        return planesMap.get(code);
    }

    public Vuelo findVuelo(String code) {
        return vuelosMap.get(code);
    }

    public Aeropuerto findAeropuerto(String code) {
        return aeropuertosMap.get(code);
    }

    public PersonClient findCliente(String DNI) {
        return clientesMap.get(DNI);
    }

    @Override
    public Seat findSeat(String fligthCode, String seatCode) {
        return findVuelo(fligthCode).getSeat(seatCode);
    }

    // ]


    //Creators, crean y/o los agrega su mapa correspondiente [

    @Override
    public void crearAeropuerto(String name, int x, int y) {
        aeropuertosMap.put(name, new Aeropuerto(name, x, y));
    }

    @Override
    public void crearCliente(int dni, String nombre) {
        PersonClient c = new PersonClient(dni, nombre);
        clientesMap.put(dni, c);
    }

    @Override
    public void crearVuelo(String flightCode, String planeCode, Aeropuerto from, Aeropuerto to, Date etd, Date eta) {
        Vuelo vuelo = new Vuelo(flightCode, findPlane(planeCode), from, to, etd, eta);
        vuelosMap.put(vuelo.getCode(), vuelo);
    }

    @Override
    public void crearAvion(String planeCode, int rows, int cols) {
        Plane plane = new Plane(planeCode, rows, cols);
        planesMap.put(planeCode, plane);
    }

    // ]


    //Reservar un asiento lamentablemente con un setter
    @Override
    public void reserveSeat(String fligthCode, String seatCode) {
        findSeat(fligthCode, seatCode).setReserved(true);
    }


    //Is in key set? [

    @Override
    public boolean isInPlaneKeySet(String key) {
        return planesMap.containsKey(key);
    }

    public boolean isInVueloKeySet(String key) {
        return vuelosMap.containsKey(key);
    }

    @Override
    public boolean isInClienteKeySet(int dni) {
        return clientesMap.containsKey(dni);
    }

    // ]


    // Datos de Prueba
    {
        // Aeropuertos
        crearAeropuerto("Austral", 0, 0);
        crearAeropuerto("Di Tella", 5, 2);
        crearAeropuerto("Salvador", 2, 10);
        crearAeropuerto("San Andres", -1, -4);

        // Aviones
        crearAvion("737", 30, 6);
        crearAvion("777", 50, 8);

        // Vuelos
        crearVuelo("0", "737", findAeropuerto("Austral"), findAeropuerto("Di Tella"), new Date("2017/7/2"), new Date("2017/7/3"));
        crearVuelo("1", "777", findAeropuerto("Salvador"), findAeropuerto("San Andres"), new Date("2/8/2017"), new Date("2017/8/3"));

        // Clientes
        crearCliente(123, "Juan Perez");
        crearCliente(1234, "John Petersen");

        //Tickets


        //Pilotos
    }


}
