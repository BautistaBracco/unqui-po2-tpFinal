package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;

import java.util.List;
import java.util.stream.Collectors;

public class MenorPrecioStrategy extends MejorCircuitoStrategy {
    public MenorPrecioStrategy(
            Terminal terminalOrigen
    ) {
        super(terminalOrigen);
    }

    @Override
    public CircuitoMaritimo getMejorCircuitoPara(
            Terminal destino, List<CircuitoMaritimo> circuitosMaritimos
    ) {
        return circuitosMaritimos
                .stream()
                .collect(Collectors.toMap(circuito -> circuito.precioEntreTramos(super.getTerminalOrigen(), destino),
                        circuito -> circuito))
                .entrySet()
                .stream()
                .min((circuitoLlaveValor1, circuitoLlaveValor2) -> circuitoLlaveValor1
                        .getKey()
                        .compareTo(circuitoLlaveValor2.getKey()))
                .get()
                .getValue();
    }

}
