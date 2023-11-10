package ar.edu.unq.po2.tpFinal.circuito;

import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;

import java.time.Duration;

public interface TramoInterface {
    TerminalInterface getPuertoOrigen();

    TerminalInterface getPuertoDestino();

    int getPrecio();

    Duration getTiempo();
}
