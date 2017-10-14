public class Asiento {
    int numero;
    boolean estado;

    public Asiento(int numero){
        this.numero=numero;
        estado=false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
