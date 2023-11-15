package ar.edu.unq.po2.tpFinal.circuito;

import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;

import java.time.Duration;

public interface CircuitoMaritimoInterface {
    Duration tiempoEntreTramos(TerminalInterface terminalOrigen, TerminalInterface terminalDestino);

    int precioEntreTramos(TerminalInterface origen, TerminalInterface destino);

    int cantidadDeTramosEntre(TerminalInterface origen, TerminalInterface destino);
}
