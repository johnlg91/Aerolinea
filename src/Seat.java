public class Seat {
    private final int row;
    private final char column;
    private boolean reserved;

    public Seat(int row, char column){
        this.row = row;
        this.column = column;
        reserved =false;
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
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Seat && ((Seat) obj).row == row && ((Seat) obj).column == column;
    }

    @Override
    public String toString() {
        return String.valueOf(row) + column;
    }
}
