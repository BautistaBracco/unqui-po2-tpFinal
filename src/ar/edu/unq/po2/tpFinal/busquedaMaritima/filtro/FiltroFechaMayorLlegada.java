package ar.edu.unq.po2.tpFinal.busquedaMaritima.filtro;

import ar.edu.unq.po2.tpFinal.busquedaMaritima.RutaMaritima;

import java.time.LocalDateTime;

public class FiltroFechaMayorLlegada extends FiltroFecha {

    public FiltroFechaMayorLlegada(LocalDateTime fecha) {
        super(fecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return ruta.getFechaDeLlegada().isAfter(this.getFecha());
    }

}
