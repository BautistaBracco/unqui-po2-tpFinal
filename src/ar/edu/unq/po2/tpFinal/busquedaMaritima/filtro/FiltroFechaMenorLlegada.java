package ar.edu.unq.po2.tpFinal.busquedaMaritima.filtro;

import ar.edu.unq.po2.tpFinal.busquedaMaritima.RutaMaritima;

import java.time.LocalDateTime;

public class FiltroFechaMenorLlegada extends FiltroFecha {

    public FiltroFechaMenorLlegada(LocalDateTime fecha) {
        super(fecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return ruta.getFechaDeLlegada().isBefore(this.getFecha());
    }
}
