package air;

import java.util.Date;
import java.util.HashMap;


public class Vuelos {
    private static HashMap<String, Vuelo> vuelos;

    public static void add(Vuelo vuelo) {
        vuelos.put(vuelo.getCode(), vuelo);
    }


    public static Vuelo findVuelo(String code) {
        return vuelos.get(code);
    }

    static {
        add(new Vuelo("0", "737", Aeropuertos.getAustral(), Aeropuertos.getITBA(), new Date(2 / 7 / 2017), new Date(3 / 7 / 2017)));
        add(new Vuelo("1", "777", Aeropuertos.getSalvador(), Aeropuertos.getUBA(), new Date(4 / 8 / 2017), new Date(5 / 8 / 2017)));
    }

}
