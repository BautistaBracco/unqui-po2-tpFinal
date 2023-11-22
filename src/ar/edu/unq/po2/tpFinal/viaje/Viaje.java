package ar.edu.unq.po2.tpFinal.viaje;

import ar.edu.unq.po2.tpFinal.BuqueInterface;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;

import java.time.Duration;
import java.time.LocalDateTime;

public class Viaje implements ViajesInterface {
    private final LocalDateTime fechaSalida;
    private final TerminalInterface terminalOrigen;
    private final CircuitoMaritimoInterface circuitoMaritimo;
    private final BuqueInterface buque;

    public Viaje(
            LocalDateTime fechaSalida, TerminalInterface terminalOrigen, CircuitoMaritimoInterface circuitoMaritimo,
            BuqueInterface buque
    ) {
        this.fechaSalida = fechaSalida;
        this.terminalOrigen = terminalOrigen;
        this.circuitoMaritimo = circuitoMaritimo;
        this.buque = buque;
    }

    public LocalDateTime getFechaDeSalida() {
    	return this.fechaSalida;
    }
    
    @Override
    public LocalDateTime getFechaDeLlegada(TerminalInterface terminalDestino) {
        return this.fechaSalida.plus(this.circuitoMaritimo.tiempoEntreTramos(terminalOrigen, terminalDestino));
    }

    public Duration getTiempoDeViaje(TerminalInterface terminalDestino) {
        return this.circuitoMaritimo.tiempoEntreTramos(terminalOrigen, terminalDestino);
    }

    public BuqueInterface getBuque() {
        return buque;
    }

    public TerminalInterface getTerminalOrigen() {
        return terminalOrigen;
    }
}
