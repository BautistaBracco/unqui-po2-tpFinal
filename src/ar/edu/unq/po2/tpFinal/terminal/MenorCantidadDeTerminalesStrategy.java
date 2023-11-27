package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;

import java.util.List;
import java.util.stream.Collectors;

public class MenorCantidadDeTerminalesStrategy implements MejorCircuitoStrategy {

    @Override
    public CircuitoMaritimo getMejorCircuitoPara(
            Terminal origen, Terminal destino, List<CircuitoMaritimo> circuitosMaritimos
    ) {
        return circuitosMaritimos
                .stream()
                .sorted((circuito1, circuito2) -> Integer.compare(circuito1.cantidadDeTramosEntre(origen, destino),
                        circuito2.cantidadDeTramosEntre(origen, destino)))
                .min((circuito1, circuito2) -> Integer.compare(circuito1.cantidadDeTramosEntre(origen, destino),
                        circuito2.cantidadDeTramosEntre(origen, destino)))
                .get();
    }


}
