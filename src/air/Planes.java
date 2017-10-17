package air;

import java.util.HashMap;

public class Planes {
    private static HashMap<String, Plane> planes;

    static void add(Plane plane) {
        planes.put(plane.getCode(), plane);
    }


    public static Plane findPlane(String code) {
        return planes.get(code);
    }
    static {
        add(new Plane("737", 30, 6));
        add(new Plane("777", 50, 8));
    }

}
