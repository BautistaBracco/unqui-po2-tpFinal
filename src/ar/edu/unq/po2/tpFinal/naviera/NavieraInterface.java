package ar.edu.unq.po2.tpFinal.naviera;

import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.viaje.ViajesInterface;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public interface NavieraInterface {
    Duration getTiempoDeViaje(TerminalInterface origen, TerminalInterface destino);
    List<ViajesInterface> getViajes();

    LocalDateTime getFechaDeProximoViaje(TerminalInterface origen, TerminalInterface destino, LocalDateTime fecha);
}
