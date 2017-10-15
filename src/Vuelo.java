import java.util.Date;

public class Vuelo {

    Date fechaSalida;
    Date fechaLlegada;
    Plane plane;
    String codigoVuelo;
    String salida;
    String destino;

    public Vuelo(String code, String planeCode) {
        plane = Planes.findPlane(planeCode)

        fechaSalida = =new Date(2017, 11, 03);
        fechaLlegada = new Date(2017, 11, 04;
        // plane=new Plane();
        codigoVuelo = "2";
        salida = "Austral";
        destino = "Itba";
    }


}
