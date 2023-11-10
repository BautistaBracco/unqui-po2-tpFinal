package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.ConsigneeInterface;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.naviera.NavieraInterface;
import ar.edu.unq.po2.tpFinal.ShipperInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Terminal implements TerminalInterface {
    private String nombre;
    private List<CamionInterface> camionesRegistrados;
    private List<ChoferInterface> choferesRegistrados;
    private List<NavieraInterface> lineasNavierasRegistradas;
    private List<ShipperInterface> shippersRegistrados;
    private List<ConsigneeInterface> consigneesRegistrados;
    private List<CircuitoMaritimoInterface> circuitosMaritimos;

    public Terminal(String nombre) {
        this.nombre = nombre;
        this.camionesRegistrados = new ArrayList<>();
        this.choferesRegistrados = new ArrayList<>();
        this.lineasNavierasRegistradas = new ArrayList<>();
        this.shippersRegistrados = new ArrayList<>();
        this.consigneesRegistrados = new ArrayList<>();
        this.circuitosMaritimos = new ArrayList<>();
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

    @Override
    public void registrarCircuitoMaritimo(CircuitoMaritimoInterface circuitoMaritimo) {
        this.circuitosMaritimos.add(circuitoMaritimo);
    }


    public CircuitoMaritimoInterface getMejorCircuito(MejorCircuitoStrategy mejorCircuitoStrategy) {
        return mejorCircuitoStrategy.getMejorCircuito();
    }
}
