package ar.edu.unq.po2.tpFinal.busquedaMaritima;

import ar.edu.unq.po2.tpFinal.terminal.Terminal;

import java.time.LocalDateTime;

public class RutaMaritima {
    private final Terminal puertoDestino;
    private final LocalDateTime fechaDeSalida;
    private final LocalDateTime fechaDeLlegada;

    public RutaMaritima(Terminal puertoDestino, LocalDateTime fechaDeSalida, LocalDateTime fechaDeLlegada) {
        this.puertoDestino = puertoDestino;
        this.fechaDeSalida = fechaDeSalida;
        this.fechaDeLlegada = fechaDeLlegada;
    }

    public LocalDateTime getFechaDeLlegada() {
        return fechaDeLlegada;
    }

    public LocalDateTime getFechaDeSalida() {
        return fechaDeSalida;
    }

    public Terminal getPuertoDestino() {
        return puertoDestino;
    }
}
