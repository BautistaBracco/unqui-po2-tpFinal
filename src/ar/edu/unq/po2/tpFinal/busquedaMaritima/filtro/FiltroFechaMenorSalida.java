package ar.edu.unq.po2.tpFinal.busquedaMaritima.filtro;

import ar.edu.unq.po2.tpFinal.busquedaMaritima.RutaMaritima;

import java.time.LocalDateTime;

public class FiltroFechaMenorSalida extends FiltroFecha {

    public FiltroFechaMenorSalida(LocalDateTime fecha) {
        super(fecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return ruta.getFechaDeSalida().isBefore(this.getFecha());
    }
}
