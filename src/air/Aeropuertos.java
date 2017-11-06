package air;

public class Aeropuertos {

    static final Aeropuerto Austral = new Aeropuerto("Austral", 0, 0);
    static final Aeropuerto Salvador = new Aeropuerto("Salvador", 5, 2);
    static final Aeropuerto Ditela = new Aeropuerto("Ditela", 2, 10);
    static final Aeropuerto SanAndres = new Aeropuerto("SanAndres", -1, -4);
    static final Aeropuerto UCA = new Aeropuerto("UCA", -6, 10);
    static final Aeropuerto UTN = new Aeropuerto("UTN", 10, 10);
    static final Aeropuerto UBA = new Aeropuerto("UBA", 8, 4);
    static final Aeropuerto ITBA = new Aeropuerto("ITBA", 10, -1);
    static final Aeropuerto UADE = new Aeropuerto("UADE", 1, -8);
    static final Aeropuerto UP = new Aeropuerto("UP", -1, 3);

    public static Aeropuerto getAustral() {
        return Austral;
    }

    public static Aeropuerto getSalvador() {
        return Salvador;
    }

    public static Aeropuerto getDitela() {
        return Ditela;
    }

    public static Aeropuerto getSanAndres() {
        return SanAndres;
    }

    public static Aeropuerto getUCA() {
        return UCA;
    }

    public static Aeropuerto getUTN() {
        return UTN;
    }

    public static Aeropuerto getUBA() {
        return UBA;
    }

    public static Aeropuerto getITBA() {
        return ITBA;
    }

    public static Aeropuerto getUADE() {
        return UADE;
    }

    public static Aeropuerto getUP() {
        return UP;
    }


}