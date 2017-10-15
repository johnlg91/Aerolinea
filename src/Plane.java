import java.util.ArrayList;

public class Plane {

    private final String code;
    private final int columns;
    private final int rows;


    public Plane(String code, int rows, int columns) {
        this.code = code;
        this.rows = rows;
        this.columns = columns;
    }


    //Que pasa si el numero de seats exede 26? --> sonamos, pero no hay aviones tan anchos...
    public ArrayList<Seat> seats() {
        ArrayList<Seat> seats = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Seat seat = new Seat(i, (char) (j + 'A'));
                seats.add(seat);
            }
        }
        return seats;
    }
}
