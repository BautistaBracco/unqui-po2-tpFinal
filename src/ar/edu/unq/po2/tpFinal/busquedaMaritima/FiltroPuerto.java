package ar.edu.unq.po2.tpFinal.busquedaMaritima;


public class FiltroPuerto implements Filtro {
    private final String nombrePuerto;

    public FiltroPuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    @Override
    public boolean aplicar(RutaMaritima ruta) {
        return ruta.getPuertoDestino().getNombre().equals(this.nombrePuerto);
    }
}
