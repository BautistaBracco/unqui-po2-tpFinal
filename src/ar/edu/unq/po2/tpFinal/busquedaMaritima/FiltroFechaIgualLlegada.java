package ar.edu.unq.po2.tpFinal.busquedaMaritima;

import java.time.LocalDateTime;

public class FiltroFechaIgualLlegada extends FiltroFecha {
    public FiltroFechaIgualLlegada(LocalDateTime fecha) {
        super(fecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return ruta.getFechaDeLlegada().isEqual(this.getFecha());
    }
}
