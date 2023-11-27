package ar.edu.unq.po2.tpFinal.circuito;

import ar.edu.unq.po2.tpFinal.terminal.Terminal;

import java.time.Duration;

public class Tramo {
    private final Terminal puertoOrigen;
    private final Terminal puertoDestino;
    private final int precio;
    private final Duration tiempo;

    public Tramo(Terminal puertoOrigen, Terminal puertoDestino, int precio, Duration tiempo) {
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
        this.precio = precio;
        this.tiempo = tiempo;
    }


    public Terminal getPuertoOrigen() {
        return this.puertoOrigen;
    }


    public Terminal getPuertoDestino() {
        return this.puertoDestino;
    }


    public int getPrecio() {
        return this.precio;
    }


    public Duration getTiempo() {
        return this.tiempo;
    }
}
