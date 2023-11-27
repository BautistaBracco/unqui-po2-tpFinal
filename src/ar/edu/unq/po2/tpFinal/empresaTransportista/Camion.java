package ar.edu.unq.po2.tpFinal.empresaTransportista;

import ar.edu.unq.po2.tpFinal.container.Container;

import java.util.ArrayList;
import java.util.List;

public class Camion {

    private final Chofer chofer;
    private final List<Container> contenedores;
    private String patente;

    public Camion(Chofer chofer, String patente) {
        this.chofer = chofer;
        this.patente = patente;
        this.contenedores = new ArrayList<>();
    }


    public void agregarContenedor(Container contenedor) {
        this.contenedores.add(contenedor);
    }


    public Chofer getChofer() {
        return this.chofer;
    }


    public int cantidadDeContenedores() {
        return this.contenedores.size();
    }


    public Object getPatente() {
        return this.patente;
    }
}
