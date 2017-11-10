package impl;

import air.Airport;
import air.Flight;
import air.Plane;
import util.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersistentServer extends BasicServer {
    private File dir;

    public PersistentServer(String dirName) {
        dir = new File(dirName);
        if (dir.exists()) loadData();
        else dir.mkdir();
    }

    private File flightsFile() {
        return new File(dir, "Flights");
    }

    private File airportsFile() {
        return new File(dir, "Airports");
    }

    private File planesFile() {
        return new File(dir, "Planes");
    }

    //Loaders [

    private void loadData() {
        loadFlights();
        loadAirports();
        loadPlanes();
    }

    private void loadFlights() {
        try {
            Scanner s = new Scanner(flightsFile());
            s.useDelimiter(";|\n");
            while (s.hasNext()) {
                String code = s.next();
                Plane plane = findPlane(s.next());
                Airport airport = findAirport(s.next());
                Airport arrival = findAirport(s.next());
                String d = s.next();
                Date etd = new Date(d);
                String s1 = s.next();
                Date eta = new Date(s1);
                Flight flight = new Flight(code, plane, airport, arrival, etd, eta);
                flightsMap.put(flight.getCode(), flight);
            }
        } catch (FileNotFoundException ignore) {
        }
    }

    private void loadAirports() {
        try {
            Scanner s = new Scanner(airportsFile());
            s.useDelimiter(";|\n");
            while (s.hasNext()) {
                Airport airport = new Airport(s.next(), s.nextDouble(), s.nextDouble());
                airportsMap.put(airport.getName(), airport);
            }
        } catch (FileNotFoundException ignore) {
        }
    }


    private void loadPlanes() {
        try {
            Scanner s = new Scanner(planesFile());
            s.useDelimiter(";|\n");
            while (s.hasNext()) {
                Plane p = new Plane(s.next(), s.nextInt(), s.nextInt(), s.nextInt());
                planesMap.put(p.getCode(), p);
            }
        } catch (FileNotFoundException ignore) {
        }
    }


    // ]

    //Savers [

    public void saveData() {
        try {
            saveFlights();
            saveAirports();
            savePlanes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveFlights() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(flightsFile());
        for (Flight a : flightsMap.values()) {
            Plane pl = a.getPlane();
            Airport from = a.getDeparture();
            Airport to = a.getArrival();
            pw.printf("%s;%s;%s;%s;%5$tD %5$tT;%6$tD %6$tT\n", a.getCode(), pl.getCode(), from.getName(), to.getName(), a.getETD(), a.getETA());
        }
        pw.close();
    }

    private void saveAirports() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(airportsFile());
        for (Airport a : airportsMap.values()) {
            Point p = a.getPoint();
            pw.printf("%s;%f;%f\n", a.getName(), p.getX(), p.getY());
        }
        pw.close();
    }

    private void savePlanes() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(planesFile());
        for (Plane p : planesMap.values()) {
            pw.printf("%s;%d;%d;%d\n", p.getCode(), p.getRows(), p.getRowsFirstClass(), p.getColumns());
        }
        pw.close();
    }

    // ]
}
