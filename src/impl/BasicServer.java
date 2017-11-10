package impl;

import air.*;
import api.Server;
import people.PersonClient;

import java.util.Date;
import java.util.TreeMap;

public class BasicServer implements Server {

    // Aeropuertos guardados en mapa
    TreeMap<String, Airport> airportsMap = new TreeMap<>();

    // Vuelos Guardados en mapa
    TreeMap<String, Flight> flightMap = new TreeMap<>();

    // Aviones Guardados en mapa
    TreeMap<String, Plane> planesMap = new TreeMap<>();

    // Clientes Guardados en mapa
    private TreeMap<Integer, PersonClient> clientMap = new TreeMap<>();

    // Tickets Guardados en mapa
    private TreeMap<String, Ticket> ticketMap = new TreeMap<>();


    //Getters para para los los keys o valores de los mapas [

    @Override
    public Iterable<String> getPlanesCodes() {
        return planesMap.keySet();
    }

    @Override
    public Iterable<Flight> getFlightMap() {
        return flightMap.values();
    }

    @Override
    public Iterable<String> getAirportsNames() {
        return airportsMap.keySet();
    }

    @Override
    public Iterable<PersonClient> getClientMap() {
        return clientMap.values();
    }

    // ]


    //Finders, retornan lo desado del mapa segun el codigo pasado [

    @Override
    public Plane findPlane(String code) {
        return planesMap.get(code);
    }

    @Override
    public Flight findFlight(String code) {
        return flightMap.get(code);
    }

    @Override
    public Airport findAirport(String code) {
        return airportsMap.get(code);
    }

    @Override
    public PersonClient findClient(int dni) {
        return clientMap.get(dni);
    }

    @Override
    public Seat findSeat(String fligthCode, String seatCode) {
        return findFlight(fligthCode).getSeat(seatCode);
    }

    // ]


    //Creators, crean y/o los agrega su mapa correspondiente [

    @Override
    public void crearAeropuerto(String aName, int x, int y) {
        airportsMap.put(aName, new Airport(aName, x, y));
    }

    @Override
    public void crearClient(int dni, String cName) {
        PersonClient c = new PersonClient(dni, cName);
        clientMap.put(dni, c);
    }

    @Override
    public void crearFlight(String flightCode, String planeCode, Airport from, Airport to, Date etd, Date eta) {
        Flight flight = new Flight(flightCode, findPlane(planeCode), from, to, etd, eta);
        flightMap.put(flight.getCode(), flight);
    }

    @Override
    public void crearPlane(String planeCode, int rowsFirstClass, int rows, int cols) {
        Plane plane = new Plane(planeCode, rowsFirstClass, rows, cols);
        planesMap.put(planeCode, plane);
    }

    // ]


    //Reservar un asiento lamentablemente con un setter
    @Override
    public void reserveSeat(String fligthCode, String seatCode, int dni) {
        Seat seat = findSeat(fligthCode, seatCode);
        PersonClient client = findClient(dni);
        seat.setReserved(true);
        Ticket t = new Ticket(client, findFlight(fligthCode), seat);
        client.addTicket(t);
    }


    //Is in key set? [

    @Override
    public boolean isInPlaneKeySet(String key) {
        return planesMap.containsKey(key);
    }

    @Override
    public boolean isInFlightKeySet(String key) {
        return flightMap.containsKey(key);
    }

    @Override
    public boolean isInClientKeySet(int dni) {
        return clientMap.containsKey(dni);
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
        crearPlane("737", 10, 20, 6);
        crearPlane("777", 15, 45, 8);

        // Vuelos
        crearFlight("0", "737", findAirport("Austral"), findAirport("Di Tella"), new Date("2017/7/2"), new Date("2017/7/3"));
        crearFlight("1", "777", findAirport("Salvador"), findAirport("San Andres"), new Date("2/8/2017"), new Date("2017/8/3"));

        // Clientes
        crearClient(123, "Juan Perez");
        crearClient(1234, "John Petersen");

        //Tickets


        //Pilotos
    }


}
