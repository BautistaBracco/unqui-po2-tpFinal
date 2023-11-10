package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;

import java.util.List;
import java.util.stream.Collectors;

public class MenorTiempoStrategy extends MejorCircuitoStrategy {


    public MenorTiempoStrategy(
            List<CircuitoMaritimoInterface> circuitosMaritimos, TerminalInterface terminalOrigen,
            TerminalInterface terminalDestino
    ) {
        super(circuitosMaritimos, terminalOrigen, terminalDestino);
    }

    @Override
    public CircuitoMaritimoInterface getMejorCircuito() {
        return super
                .getCircuitosMaritimos()
                .stream()
                .collect(Collectors.toMap(circuito -> circuito.tiempoEntreTramos(super.getTerminalOrigen(),
                                                                                 super.getTerminalDestino()),
                                          circuito -> circuito))
                .entrySet()
                .stream()
                .min((circuitoLlaveValor1, circuitoLlaveValor2) -> circuitoLlaveValor1
                        .getKey()
                        .compareTo(circuitoLlaveValor2.getKey()))
                .orElse(null)
                .getValue();
    }
}
