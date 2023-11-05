package ar.edu.unq.po2.tpFinal.empresaTransportista;

import ar.edu.unq.po2.tpFinal.ContenedorInterface;

import java.util.ArrayList;
import java.util.List;

public class Camion implements CamionInterface {

    private final ChoferInterface chofer;
    private final List<ContenedorInterface> contenedores;
    private String patente;

    public Camion(ChoferInterface chofer, String patente) {
        this.chofer = chofer;
        this.patente = patente;
        this.contenedores = new ArrayList<>();
    }

    @Override
    public void agregarContenedor(ContenedorInterface contenedor) {
        this.contenedores.add(contenedor);
    }

    @Override
    public ChoferInterface getChofer() {
        return this.chofer;
    }

    @Override
    public int cantidadDeContenedores() {
        return this.contenedores.size();
    }

    @Override
    public Object getPatente() {
        return this.patente;
    }
}
