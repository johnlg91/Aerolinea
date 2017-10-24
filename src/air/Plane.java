package air;

import java.util.LinkedHashMap;
import java.util.Map;

public class Plane {

    private final String code;
    private final int columns;
    private final int rows;


    public Plane(String code, int rows, int columns) {
        this.code = code;
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public String toString() {
        return code;
    }

    public String getCode() {
        return code;
    }

    //Que pasa si el numero de seats exede 26? --> sonamos, pero no hay aviones tan anchos...
    public Map<String, Seat> seats() {
        Map<String, Seat> seats = new LinkedHashMap<>();
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Seat seat = new Seat(i, (char) (j + 'A'));
                seats.put(seat.toString(), seat);
            }
        }
        return seats;
    }
}
