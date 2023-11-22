package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.ConsigneeInterface;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.naviera.NavieraInterface;
import ar.edu.unq.po2.tpFinal.ShipperInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Terminal implements TerminalInterface {
    private String nombre;
    private MejorCircuitoStrategy mejorCircuitoStrategy;
    private List<CamionInterface> camionesRegistrados;
    private List<ChoferInterface> choferesRegistrados;
    private List<NavieraInterface> lineasNavierasRegistradas;
    private List<ShipperInterface> shippersRegistrados;
    private List<ConsigneeInterface> consigneesRegistrados;
    private List<CircuitoMaritimoInterface> circuitosMaritimos;

    public Terminal(String nombre) {
        this.nombre = nombre;
        this.mejorCircuitoStrategy = new MenorTiempoStrategy(this);
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

    public void setMejorCircuitoStrategy(MejorCircuitoStrategy mejorCircuitoStrategy) {
        this.mejorCircuitoStrategy = mejorCircuitoStrategy;
    }

    public CircuitoMaritimoInterface getMejorCircuito(TerminalInterface destino) {
        return mejorCircuitoStrategy.getMejorCircuitoPara(destino, this.circuitosMaritimos);
    }

    public Duration cuantoTardaNavieraEnIrA(TerminalInterface destino, NavieraInterface naviera) {
        return naviera.getTiempoDeViaje(this, destino);
    }

    public LocalDateTime proximoBuqueA(TerminalInterface destino, LocalDateTime fecha) {
        return this.lineasNavierasRegistradas
                .stream()
                .map(lineaNaviera -> lineaNaviera.getViajes())
                .flatMap(viajes -> viajes.stream()) // aplana el stream de listas de listas de viajes y lo convierte en un stream de listas de viajes
                .filter(viaje -> viaje.getTerminalOrigen().getNombre().equals(this.nombre) &&
                                 viaje.existeDestino(destino) &&
                                 viaje.getFechaDeSalida().isAfter(fecha))
                .map(viaje -> viaje.getFechaDeSalida())
                .min((fecha1, fecha2) -> fecha1.compareTo(fecha2))
                .get();
    }
}
