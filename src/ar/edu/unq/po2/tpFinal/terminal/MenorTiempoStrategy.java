package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;

import java.util.List;
import java.util.stream.Collectors;

public class MenorTiempoStrategy extends MejorCircuitoStrategy {


    public MenorTiempoStrategy(
            TerminalInterface terminalOrigen
    ) {
        super(terminalOrigen);
    }

    @Override
    public CircuitoMaritimoInterface getMejorCircuitoPara(
            TerminalInterface destino, List<CircuitoMaritimoInterface> circuitosMaritimos
    ) {
        return circuitosMaritimos
                .stream()
                .collect(Collectors.toMap(circuito -> circuito.tiempoEntreTramos(super.getTerminalOrigen(), destino),
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
