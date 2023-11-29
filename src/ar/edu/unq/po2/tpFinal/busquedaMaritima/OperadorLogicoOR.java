package ar.edu.unq.po2.tpFinal.busquedaMaritima;

public class OperadorLogicoOR extends OperadorLogico {


    public OperadorLogicoOR(Filtro filtroIzquierda, Filtro filtroDerecha) {
        super(filtroIzquierda, filtroDerecha);
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return this.getFiltroIzquierda().aplicar(ruta) || this.getFiltroDerecha().aplicar(ruta);
    }
}

