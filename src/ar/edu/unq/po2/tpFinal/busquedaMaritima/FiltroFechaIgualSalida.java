package ar.edu.unq.po2.tpFinal.busquedaMaritima;

import java.time.LocalDateTime;

public class FiltroFechaIgualSalida extends FiltroFecha {
    public FiltroFechaIgualSalida(LocalDateTime fecha) {
        super(fecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return ruta.getFechaDeSalida().isEqual(this.getFecha());
    }
}
