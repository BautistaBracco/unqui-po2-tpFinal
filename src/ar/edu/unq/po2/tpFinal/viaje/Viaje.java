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

    @Override
    public LocalDateTime getFechaDeLlegada(TerminalInterface terminalDestino) {
        System.out.println("this.fechaSalida = " + this.fechaSalida);
        System.out.println("this.circuitoMaritimo.tiempoEntreTramos(" +
                                   this.terminalOrigen.getNombre() +
                                   ", " +
                                   terminalDestino.getNombre() +
                                   ") = " +
                                   this.circuitoMaritimo
                                           .tiempoEntreTramos(this.terminalOrigen, terminalDestino)
                                           .toString());
        return this.fechaSalida.plus(this.circuitoMaritimo.tiempoEntreTramos(terminalOrigen, terminalDestino));
    }

    public BuqueInterface getBuque() {
        return buque;
    }

    public TerminalInterface getTerminalOrigen() {
        return terminalOrigen;
    }
}
