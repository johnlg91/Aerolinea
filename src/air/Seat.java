package air;

public class Seat {
    private final char column;
    private final int rowFirstClass;
    private final int row;
    private boolean reserved;

    Seat(int rowFirstClass, int row, char column) {
        this.rowFirstClass = rowFirstClass;
        this.row = row;
        this.column = column;
        reserved = false;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getRowFirstClass() {
        return rowFirstClass;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return String.valueOf(rowFirstClass + row) + column;
    }
}
