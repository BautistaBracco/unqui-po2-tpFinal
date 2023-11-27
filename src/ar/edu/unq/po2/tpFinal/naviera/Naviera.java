package ar.edu.unq.po2.tpFinal.naviera;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Naviera {
    private List<Buque> buques;
    private List<CircuitoMaritimo> circuitos;
    private List<Viaje> viajes;

    public Naviera() {
        this.buques = new ArrayList<>();
        this.circuitos = new ArrayList<>();
        this.viajes = new ArrayList<>();
    }

    public void agregarBuque(Buque buque) {
        this.buques.add(buque);
    }

    public void agregarCircuito(CircuitoMaritimo circuito) {
        this.circuitos.add(circuito);
    }

    public void agregarViaje(Viaje viaje) {
        this.viajes.add(viaje);
    }

    public List<Buque> getBuques() {
        return this.buques;
    }

    public List<CircuitoMaritimo> getCircuitos() {
        return this.circuitos;
    }

    public List<Viaje> getViajes() {
        return this.viajes;
    }


    public LocalDateTime getFechaDeProximoViaje(
            Terminal origen, Terminal destino, LocalDateTime fecha
    ) {
        return this.viajes
                .stream()
                .filter(viaje -> viaje.tieneMismaTerminalOrigen(origen) &&
                                 viaje.existeDestino(destino) &&
                                 viaje.getFechaDeSalida().isAfter(fecha))
                .map(viajes -> viajes.getFechaDeSalida())
                .min((localDateTime, other) -> localDateTime.compareTo(other))
                .get();
    }

    public List<CircuitoMaritimo> getCircuitosConTerminalesDeOrigenYDestino(
            Terminal origen, Terminal destino
    ) {
        return this.circuitos
                .stream()
                .filter(circuito -> circuito.existeTerminal(origen) && circuito.existeTerminal(destino))
                .toList();
    }

    public Duration getTiempoDeViaje(Terminal origen, Terminal destino) {
        return this
                .getCircuitosConTerminalesDeOrigenYDestino(origen, destino)
                .stream()
                .map(circuito -> circuito.tiempoEntreTramos(origen, destino))
                .min(Duration::compareTo)
                .get();
    }

}
