package air;

import util.Point;

public class Airport {
    private final String name;
    private final Point point;

    public Airport(String name, double x, double y) {
        this.name = name;
        this.point = new Point(x, y);
    }

    public double getDistance(Airport to){
        return this.point.getDistance(to.point);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }
}
