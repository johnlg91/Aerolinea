package air;

import java.util.LinkedHashMap;
import java.util.Map;

public class Plane {

    private final String code;
    private final int columns;
    private final int rowsFirstClass;
    private final int rows;


    public Plane(String code, int rowsFirstClass, int rows, int columns) {
        this.code = code;
        this.rowsFirstClass = rowsFirstClass;
        this.rows = rows;
        this.columns = columns;
    }

    public String getCode() {
        return code;
    }

    public Map<String, Seat> seatsFirst() {
        Map<String, Seat> seatsFirst = new LinkedHashMap<>();
        for (int i = 1; i < rowsFirstClass; i++) {
            for (int j = 0; j < columns; j++) {
                Seat seat = new Seat(i, 0, (char) (j + 'A'));
                seatsFirst.put(seat.toString(), seat);
            }
        }
        return seatsFirst;
    }


    public Map<String, Seat> seats() {
        Map<String, Seat> seats = new LinkedHashMap<>();
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Seat seat = new Seat(0, i, (char) (j + 'M'));
                seats.put(seat.toString(), seat);
            }
        }
        return seats;
    }



    @Override
    public String toString() {
        return code;
    }

    public int getColumns() {
        return columns;
    }

    public int getRowsFirstClass() {
        return rowsFirstClass;
    }

    public int getRows() {
        return rows;
    }
}