package util;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Point X1){
        return Math.sqrt(Math.pow(x-X1.getX(),2)+Math.pow(y-X1.getY(),2));

    }
}
