package ar.edu.unq.po2.tpFinal.empresaTransportista;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransportista {
    private final String nombre;
    private final List<Camion> camiones;
    private final List<Chofer> choferes;

    public EmpresaTransportista(String nombre) {
        this.nombre = nombre;
        this.camiones = new ArrayList<>();
        this.choferes = new ArrayList<>();
    }


    public String getNombre() {
        return this.nombre;
    }


    public void agregarCamion(Camion camion) {
        this.camiones.add(camion);
    }


    public void agregarChofer(Chofer chofer) {
        this.choferes.add(chofer);
    }


    public int cantidadDeChoferes() {
        return this.choferes.size();
    }


    public int cantidadDeCamiones() {
        return this.camiones.size();
    }
}
