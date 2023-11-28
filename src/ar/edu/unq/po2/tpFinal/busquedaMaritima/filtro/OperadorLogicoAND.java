package ar.edu.unq.po2.tpFinal.busquedaMaritima.filtro;

import ar.edu.unq.po2.tpFinal.busquedaMaritima.RutaMaritima;

public class OperadorLogicoAND extends OperadorLogico {

    public OperadorLogicoAND(Filtro filtroIzquierda, Filtro filtroDerecha) {
        super(filtroIzquierda, filtroDerecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return this.getFiltroIzquierda().aplicar(ruta) && this.getFiltroDerecha().aplicar(ruta);
    }
}
