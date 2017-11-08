package air;

import util.Point;

public class Airport {
    private final String airport;
    private final Point point;

    public Airport(String airport, int x, int y) {
        this.airport = airport;
        this.point = new Point(x, y);
    }

    public double getDistance(Airport to){
        return this.point.getDistance(to.point);
    }

    @Override
    public String toString() {
        return airport;
    }
}
