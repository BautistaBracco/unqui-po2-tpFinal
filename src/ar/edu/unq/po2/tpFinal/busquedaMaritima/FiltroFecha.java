package ar.edu.unq.po2.tpFinal.busquedaMaritima;


import java.time.LocalDateTime;

public abstract class FiltroFecha implements Filtro {
    private final LocalDateTime fecha;

    public FiltroFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public abstract boolean aplicar(RutaMaritima ruta);
}
