package ar.edu.unq.po2.tpFinal.empresaTransportista;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransportista implements EmpresaTransportistaInterface {
    private final String nombre;
    private final List<CamionInterface> camiones;
    private final List<ChoferInterface> choferes;

    public EmpresaTransportista(String nombre) {
        this.nombre = nombre;
        this.camiones = new ArrayList<>();
        this.choferes = new ArrayList<>();
    }


    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void agregarCamion(CamionInterface camion) {
        this.camiones.add(camion);
    }

    @Override
    public void agregarChofer(ChoferInterface chofer) {
        this.choferes.add(chofer);
    }

    @Override
    public int cantidadDeChoferes() {
        return this.choferes.size();
    }

    @Override
    public int cantidadDeCamiones() {
        return this.camiones.size();
    }
}
