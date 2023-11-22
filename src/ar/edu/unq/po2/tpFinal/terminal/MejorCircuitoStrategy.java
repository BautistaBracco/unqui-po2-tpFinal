package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;

import java.util.List;

public abstract class MejorCircuitoStrategy {
    private TerminalInterface terminalOrigen;

    public MejorCircuitoStrategy(
            TerminalInterface terminalOrigen
    ) {
        this.terminalOrigen = terminalOrigen;
    }

    public abstract CircuitoMaritimoInterface getMejorCircuitoPara(
            TerminalInterface destino, List<CircuitoMaritimoInterface> circuitosMaritimos
    );

    public TerminalInterface getTerminalOrigen() {
        return terminalOrigen;
    }

}
