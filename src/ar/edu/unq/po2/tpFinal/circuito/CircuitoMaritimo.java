package ar.edu.unq.po2.tpFinal.circuito;

import ar.edu.unq.po2.tpFinal.terminal.Terminal;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CircuitoMaritimo {
    private final List<Tramo> tramos;

    public CircuitoMaritimo() {
        this.tramos = new ArrayList<>();
    }

    // Tengo que ordenar los tramos?
    /*
     * 1. El mismo tramo no se puede agregar más de una vez
     * 2. El tramo no puede tener el mismo puerto de origen y destino que otro tramo
     * 3. El puerto de destino del último tramo debe ser el mismo que el puerto de origen que el primer tramo
     * */
    public void agregarTramo(Tramo tramo) {
        this.tramos.add(tramo);
    }

    public int cantidadDeTramos() {
        return this.tramos.size();
    }


    // si falla es porque hay al menos un tramo que no está conectado con ninguno
    private List<Tramo> tramosEntre(Terminal origen, Terminal destino) {

        List<Tramo> tramos = new ArrayList<>();
        if (!this.existeTerminal(origen) || !this.existeTerminal(destino)) {
            System.out.println("No existe puerto");
            return tramos;
        }

        Tramo tramoActual = this.getTramoConOrigen(origen);
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

    public int cantidadDeTramosEntre(Terminal origen, Terminal destino) {
        return this.tramosEntre(origen, destino).size();
    }

    public int precioEntreTramos(Terminal origen, Terminal destino) {
        return this.tramosEntre(origen, destino).stream().mapToInt(tramo -> tramo.getPrecio()).sum();
    }

    public int precioTotalDelCircuito() {
        return this.tramos.stream().mapToInt(tramo -> tramo.getPrecio()).sum();
    }

    public Duration tiempoEntreTramos(Terminal origen, Terminal destino) {
        return this
                .tramosEntre(origen, destino)
                .stream()
                .reduce(Duration.ZERO,
                        (tiempo, tramo) -> tiempo.plus(tramo.getTiempo()),
                        (tiempo1, tiempo2) -> tiempo1.plus(tiempo2));
    }

    public Duration tiempoTotalDelCircuito() {
        return this.tramos
                .stream()
                .reduce(Duration.ZERO,
                        (tiempo, tramo) -> tiempo.plus(tramo.getTiempo()),
                        (tiempo1, tiempo2) -> tiempo1.plus(tiempo2));
    }

    private Tramo getTramoConOrigen(Terminal origen) {
        return this.tramos
                .stream()
                .filter(tramo -> tramo.getPuertoOrigen().getNombre().equals(origen.getNombre()))
                .findFirst()
                .get();
    }

    public boolean existeTerminal(Terminal terminal) {
        return this.tramos
                .stream()
                .anyMatch(tramo -> Objects.equals(tramo.getPuertoOrigen().getNombre(), terminal.getNombre()) ||
                                   Objects.equals(tramo.getPuertoDestino().getNombre(), terminal.getNombre()));
    }
}
