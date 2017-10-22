package air;

import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;


public class Vuelos {
    private static TreeMap<String, Vuelo> vuelos = new TreeMap<>();

    public static void add(Vuelo vuelo) {
        vuelos.put(vuelo.getCode(), vuelo);
    }


    public static Vuelo findVuelo(String code) {
        return vuelos.get(code);
    }

    static {
        add(new Vuelo("0", "737", Aeropuertos.getAustral(), Aeropuertos.getITBA(), new Date("2017/7/2"), new Date("2017/7/3")));
        add(new Vuelo("1", "777", Aeropuertos.getSalvador(), Aeropuertos.getUBA(), new Date("2/8/2017"), new Date("2017/8/3")));
    }

    public static Collection<Vuelo> list() {
        return vuelos.values();
    }
}
