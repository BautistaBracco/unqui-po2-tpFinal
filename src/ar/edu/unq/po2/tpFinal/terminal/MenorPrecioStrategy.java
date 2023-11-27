package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;

import java.util.List;
import java.util.stream.Collectors;

public class MenorPrecioStrategy implements MejorCircuitoStrategy {

    @Override
    public CircuitoMaritimo getMejorCircuitoPara(
            Terminal origen, Terminal destino, List<CircuitoMaritimo> circuitosMaritimos
    ) {
        return circuitosMaritimos
                .stream()
                .sorted((circuito1, circuito2) -> Integer.compare(circuito1.precioEntreTramos(origen, destino),
                        circuito2.precioEntreTramos(origen, destino)))
                .min((circuito1, circuito2) -> Integer.compare(circuito1.precioEntreTramos(origen, destino),
                        circuito2.precioEntreTramos(origen, destino)))
                .get();
    }

}
