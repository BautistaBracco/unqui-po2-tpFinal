package ar.edu.unq.po2.tpFinal.naviera;

import ar.edu.unq.po2.tpFinal.BuqueInterface;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import ar.edu.unq.po2.tpFinal.viaje.ViajesInterface;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Naviera implements NavieraInterface {
    private List<BuqueInterface> buques;
    private List<CircuitoMaritimoInterface> circuitos;
    private List<ViajesInterface> viajes;

    public Naviera() {
        this.buques = new ArrayList<>();
        this.circuitos = new ArrayList<>();
        this.viajes = new ArrayList<>();
    }

    public void agregarBuque(BuqueInterface buque) {
        this.buques.add(buque);
    }

    public void agregarCircuito(CircuitoMaritimoInterface circuito) {
        this.circuitos.add(circuito);
    }

    public void agregarViaje(ViajesInterface viaje) {
        this.viajes.add(viaje);
    }

    public List<BuqueInterface> getBuques() {
        return this.buques;
    }

    public List<CircuitoMaritimoInterface> getCircuitos() {
        return this.circuitos;
    }

    public List<ViajesInterface> getViajes() {
        return this.viajes;
    }

    @Override
    public LocalDateTime getFechaDeProximoViaje(
            TerminalInterface origen, TerminalInterface destino, LocalDateTime fecha
    ) {
        return this.viajes
                .stream()
                .filter(viaje -> viaje.tieneMismaTerminalOrigen(origen) &&
                                 viaje.existeDestino(destino) &&
                                 viaje.getFechaDeSalida().isAfter(fecha))
                .map(viajesInterface -> viajesInterface.getFechaDeSalida())
                .min((localDateTime, other) -> localDateTime.compareTo(other))
                .get();
    }

    public List<CircuitoMaritimoInterface> getCircuitosConTerminalesDeOrigenYDestino(
            TerminalInterface origen, TerminalInterface destino
    ) {
        return this.circuitos
                .stream()
                .filter(circuito -> circuito.existeTerminal(origen) && circuito.existeTerminal(destino))
                .toList();
    }

    public Duration getTiempoDeViaje(TerminalInterface origen, TerminalInterface destino) {
        return this
                .getCircuitosConTerminalesDeOrigenYDestino(origen, destino)
                .stream()
                .map(circuito -> circuito.tiempoEntreTramos(origen, destino))
                .min(Duration::compareTo)
                .get();
    }

}
