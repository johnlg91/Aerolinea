package air;

import java.util.Set;
import java.util.TreeMap;

public class Planes {

    private static TreeMap<String, Plane> planesMap = new TreeMap<>();

    static void add(Plane plane) {
        planesMap.put(plane.getCode(), plane);
    }


    public static Plane findPlane(String code) {
        return planesMap.get(code);
    }

    static {
        add(new Plane("737", 30, 6));
        add(new Plane("777", 50, 8));
    }

    public static Set<String> getPlanes() {
        return planesMap.keySet();
    }

}
