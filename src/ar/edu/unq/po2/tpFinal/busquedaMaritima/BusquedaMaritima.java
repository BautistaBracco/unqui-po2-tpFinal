package ar.edu.unq.po2.tpFinal.busquedaMaritima;

import ar.edu.unq.po2.tpFinal.busquedaMaritima.filtro.Filtro;

import java.util.List;

public class BusquedaMaritima {
    private List<Filtro> filtros;
    private List<RutaMaritima> rutas;

    public BusquedaMaritima(List<Filtro> filtros, List<RutaMaritima> rutas) {
        this.filtros = filtros;
        this.rutas = rutas;
    }

    public List<RutaMaritima> buscar() {
        return this.rutas
                .stream()
                .filter(ruta -> this.filtros.stream().allMatch(filtro -> filtro.aplicar(ruta)))
                .toList();
    }
}
