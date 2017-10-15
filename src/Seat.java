public class Seat {
    private final char column;
    private final int row;
    private boolean reserved;

    public Seat(char column, int row) {
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

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return String.valueOf(row) + column;
    }
}