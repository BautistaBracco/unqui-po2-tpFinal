package ar.edu.unq.po2.tpFinal.busquedaMaritima;


import java.time.LocalDateTime;

public class FiltroFechaMayorSalida extends FiltroFecha {

    public FiltroFechaMayorSalida(LocalDateTime fecha) {
        super(fecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return ruta.getFechaDeSalida().isAfter(this.getFecha());
    }
}
