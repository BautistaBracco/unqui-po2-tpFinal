package ar.edu.unq.po2.tpFinal.circuito;


import ar.edu.unq.po2.tpFinal.BuqueInterface;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CircuitoMaritimo {
    private final List<TramoInterface> tramos;
    private final List<BuqueInterface> buques;

    public CircuitoMaritimo() {
        this.tramos = new ArrayList<>();
        this.buques = new ArrayList<>();
    }

    public void agregarBuque(BuqueInterface buque) {
        this.buques.add(buque);
    }

    public int cantidadDeBuques() {
        return this.buques.size();
    }

    // Tengo que ordenar los tramos?
    /*
     * 1. El mismo tramo no se puede agregar más de una vez
     * 2. El tramo no puede tener el mismo puerto de origen y destino que otro tramo
     * 3. El puerto de destino del último tramo debe ser el mismo que el puerto de origen que el primer tramo
     * */
    public void agregarTramo(TramoInterface tramo) {
        this.tramos.add(tramo);
    }

    public int cantidadDeTramos() {
        return this.tramos.size();
    }


    // si falla es porque hay al menos un tramo que no esta conectado con ninguno
    private List<TramoInterface> tramosEntre(TerminalInterface origen, TerminalInterface destino) {

        List<TramoInterface> tramos = new ArrayList<>();
        if (!this.existePuerto(origen) || !this.existePuerto(destino)) {
            System.out.println("No existe puerto");
            return tramos;
        }

        TramoInterface tramoActual = this.getTramoConOrigen(origen);
        tramos.add(tramoActual);

        // verifico que el si el primer tramo contiene el destino
        if (Objects.equals(tramoActual.getPuertoDestino().getNombre(), destino.getNombre())) {
            return tramos;
        }

        // se ejecuta al menos una vez
        do {
            tramoActual = this.getTramoConOrigen(tramoActual.getPuertoDestino());
            tramos.add(tramoActual);
        } while (!tramoActual.getPuertoDestino().getNombre().equals(destino.getNombre()));

        return tramos;
    }

    public int cantidadDeTramosEntre(TerminalInterface origen, TerminalInterface destino) {
        return this.tramosEntre(origen, destino).size();
    }

    public int precioEntreTramos(TerminalInterface origen, TerminalInterface destino) {
        return this.tramosEntre(origen, destino).stream().mapToInt(tramo -> tramo.getPrecio()).sum();
    }

    public int precioTotalDelCircuito() {
        return this.tramos.stream().mapToInt(tramo -> tramo.getPrecio()).sum();
    }

    public int tiempoEntreTramos(TerminalInterface origen, TerminalInterface destino) {
        return this.tramosEntre(origen, destino).stream().mapToInt(tramo -> tramo.getTiempo()).sum();
    }

    public int tiempoTotalDelCircuito() {
        return this.tramos.stream().mapToInt(tramo -> tramo.getTiempo()).sum();
    }

    private TramoInterface getTramoConOrigen(TerminalInterface origen) {
        return this.tramos
                .stream()
                .filter(tramo -> tramo.getPuertoOrigen().getNombre().equals(origen.getNombre()))
                .findFirst()
                .orElse(null);
    }

    private boolean existePuerto(TerminalInterface terminal) {
        return this.tramos
                .stream()
                .anyMatch(tramo -> Objects.equals(tramo.getPuertoOrigen().getNombre(), terminal.getNombre()) ||
                        Objects.equals(tramo.getPuertoDestino().getNombre(), terminal.getNombre()));
    }
}
