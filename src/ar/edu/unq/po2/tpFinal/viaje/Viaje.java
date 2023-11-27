package ar.edu.unq.po2.tpFinal.viaje;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;

import java.time.Duration;
import java.time.LocalDateTime;

public class Viaje {
    private final LocalDateTime fechaSalida;
    private final Terminal terminalOrigen;
    private final CircuitoMaritimo circuitoMaritimo;
    private final Buque buque;

    public Viaje(
            LocalDateTime fechaSalida, Terminal terminalOrigen, CircuitoMaritimo circuitoMaritimo, Buque buque
    ) {
        this.fechaSalida = fechaSalida;
        this.terminalOrigen = terminalOrigen;
        this.circuitoMaritimo = circuitoMaritimo;
        this.buque = buque;
    }

    public LocalDateTime getFechaDeLlegada(Terminal terminalDestino) {
        return this.fechaSalida.plus(this.circuitoMaritimo.tiempoEntreTramos(terminalOrigen, terminalDestino));
    }

    public LocalDateTime getFechaDeSalida() {
        return this.fechaSalida;
    }

    public Duration getTiempoDeViaje(Terminal terminalDestino) {
        return this.circuitoMaritimo.tiempoEntreTramos(terminalOrigen, terminalDestino);
    }

    public Buque getBuque() {
        return buque;
    }

    public Terminal getTerminalOrigen() {
        return terminalOrigen;
    }


    public boolean existeDestino(Terminal terminalDestino) {
        return this.circuitoMaritimo.existeTerminal(terminalDestino);
    }


    public boolean tieneMismaTerminalOrigen(Terminal terminalOrigen) {
        return this.terminalOrigen.getNombre() == terminalOrigen.getNombre();
    }


    public int costoDeViaje(Terminal terminalDestino) {
        return circuitoMaritimo.precioEntreTramos(terminalOrigen, terminalDestino);
    }
}
