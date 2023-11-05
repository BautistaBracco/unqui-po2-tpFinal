package ar.edu.unq.po2.tpFinal.circuito;

import ar.edu.unq.po2.tpFinal.TerminalInterface;

public interface TramoInterface {
    TerminalInterface getPuertoOrigen();

    TerminalInterface getPuertoDestino();

    int getPrecio();

    int getTiempo();
}
