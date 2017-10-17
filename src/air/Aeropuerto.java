package air;

import util.Point;

public class Aeropuerto {
    private final String aeropuerto;
    private final Point point;

    public Aeropuerto(String aeropuerto, int x, int y) {
        this.aeropuerto = aeropuerto;
        this.point = new Point(x, y);
    }

    public double getDistance(Aeropuerto to){
        return this.point.getDistance(to.point);
    }

    @Override
    public String toString() {
        return aeropuerto;
    }
}
