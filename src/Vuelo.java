import java.util.ArrayList;

public class Vuelo {

    double fechaSalida;
    double fechaLlegada;
    Avion avion;
    String codigoVuelo;
    String salida;
    String destino;

    public Vuelo(){
        fechaSalida=20171103;
        fechaLlegada=20171104;
        avion=new Avion();
        codigoVuelo="2";
        salida="Austral";
        destino="Itba";
    }


}
