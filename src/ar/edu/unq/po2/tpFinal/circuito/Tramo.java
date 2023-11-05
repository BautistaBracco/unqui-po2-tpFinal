package ar.edu.unq.po2.tpFinal.circuito;

import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;

public class Tramo implements TramoInterface {
    private final TerminalInterface puertoOrigen;
    private final TerminalInterface puertoDestino;
    private final int precio;
    private final int tiempo;

    public Tramo(TerminalInterface puertoOrigen, TerminalInterface puertoDestino, int precio, int tiempo) {
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
        this.precio = precio;
        this.tiempo = tiempo;
    }

    @Override
    public TerminalInterface getPuertoOrigen() {
        return this.puertoOrigen;
    }

    @Override
    public TerminalInterface getPuertoDestino() {
        return this.puertoDestino;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }

    @Override
    public int getTiempo() {
        return this.tiempo;
    }
}
