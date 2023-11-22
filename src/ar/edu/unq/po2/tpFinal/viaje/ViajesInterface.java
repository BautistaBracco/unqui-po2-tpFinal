package ar.edu.unq.po2.tpFinal.viaje;

import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;

import java.time.Duration;
import java.time.LocalDateTime;

public interface ViajesInterface {
    LocalDateTime getFechaDeLlegada(TerminalInterface terminalDestino);
    LocalDateTime getFechaDeSalida();
    TerminalInterface getTerminalOrigen();
    boolean existeDestino(TerminalInterface terminalDestino);
    double costoDeViaje(TerminalInterface terminalDestino);
}
