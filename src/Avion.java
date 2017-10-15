public class Avion {

    String codigoAvion;
    int column;
    int row;

    public Avion(int row, int column) {
        this.row = row;
        this.column = column;
        codigoAvion = "1";
    }


    public String getCodigoAvion() {
        return codigoAvion;
    }

    //Que pasa si el numero de asientos exede 26?
    public void asientos() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                String name = (char)i+j;
                Seat name = new Seat((char) i, j);
            }
        }
    }
}
