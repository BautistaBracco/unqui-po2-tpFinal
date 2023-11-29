package ar.edu.unq.po2.tpFinal.busquedaMaritima;


public abstract class OperadorLogico implements Filtro {

    private final Filtro filtroIzquierda;
    private final Filtro filtroDerecha;

    OperadorLogico(Filtro filtroIzquierda, Filtro filtroDerecha) {
        this.filtroIzquierda = filtroIzquierda;
        this.filtroDerecha = filtroDerecha;
    }

    @Override
    public abstract boolean aplicar(RutaMaritima ruta);

    public Filtro getFiltroIzquierda() {
        return filtroIzquierda;
    }

    public Filtro getFiltroDerecha() {
        return filtroDerecha;
    }
}
