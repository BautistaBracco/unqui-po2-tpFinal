package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;

import java.util.List;

public abstract class MejorCircuitoStrategy {
    private List<CircuitoMaritimoInterface> circuitosMaritimos;
    private TerminalInterface terminalOrigen;
    private TerminalInterface terminalDestino;

    public MejorCircuitoStrategy(
            List<CircuitoMaritimoInterface> circuitosMaritimos, TerminalInterface terminalOrigen,
            TerminalInterface terminalDestino
    ) {
        this.circuitosMaritimos = circuitosMaritimos;
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
    }

    public abstract CircuitoMaritimoInterface getMejorCircuito();

    public List<CircuitoMaritimoInterface> getCircuitosMaritimos() {
        return circuitosMaritimos;
    }

    public TerminalInterface getTerminalOrigen() {
        return terminalOrigen;
    }

    public TerminalInterface getTerminalDestino() {
        return terminalDestino;
    }
}
