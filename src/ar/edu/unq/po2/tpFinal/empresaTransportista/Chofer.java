package ar.edu.unq.po2.tpFinal.empresaTransportista;

public class Chofer implements ChoferInterface {
    private final String nombre;

    public Chofer(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
