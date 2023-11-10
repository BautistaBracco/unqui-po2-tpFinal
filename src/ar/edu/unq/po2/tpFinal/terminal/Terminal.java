package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.ConsigneeInterface;
import ar.edu.unq.po2.tpFinal.naviera.NavieraInterface;
import ar.edu.unq.po2.tpFinal.ShipperInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

import java.util.ArrayList;
import java.util.List;

public class Terminal implements TerminalInterface {
    private List<CamionInterface> camionesRegistrados;
    private List<ChoferInterface> choferesRegistrados;
    private List<NavieraInterface> lineasNavierasRegistradas;
    private List<ShipperInterface> shippersRegistrados;
    private List<ConsigneeInterface> consigneesRegistrados;
    private String nombre;

    public Terminal(String nombre) {
        this.nombre = nombre;
        this.camionesRegistrados = new ArrayList<>();
        this.choferesRegistrados = new ArrayList<>();
        this.lineasNavierasRegistradas = new ArrayList<>();
        this.shippersRegistrados = new ArrayList<>();
        this.consigneesRegistrados = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void registrarLineaNaviera(NavieraInterface lineaNaviera) {
        this.lineasNavierasRegistradas.add(lineaNaviera);
    }

    @Override
    public void registrarShipper(ShipperInterface shipper) {
        this.shippersRegistrados.add(shipper);
    }

    @Override
    public void registrarConsignee(ConsigneeInterface consignee) {
        this.consigneesRegistrados.add(consignee);
    }

    @Override
    public void registrarCamion(CamionInterface camion) {
        this.camionesRegistrados.add(camion);
    }

    @Override
    public boolean estaElCamionRegistrado(CamionInterface camion) {
        return this.camionesRegistrados.stream().anyMatch(c -> c.getPatente().equals(camion.getPatente()));
    }

    @Override
    public void registrarChofer(ChoferInterface chofer) {
        this.choferesRegistrados.add(chofer);
    }

    @Override
    public boolean estaElChoferRegistrado(ChoferInterface chofer) {
        return this.choferesRegistrados.stream().anyMatch(c -> c.getNombre().equals(chofer.getNombre()));
    }


}
