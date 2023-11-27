package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;

import java.util.List;

public abstract class MejorCircuitoStrategy {
    private Terminal terminalOrigen;

    public MejorCircuitoStrategy(
            Terminal terminalOrigen
    ) {
        this.terminalOrigen = terminalOrigen;
    }

    public abstract CircuitoMaritimo getMejorCircuitoPara(
            Terminal destino, List<CircuitoMaritimo> circuitosMaritimos
    );

    public Terminal getTerminalOrigen() {
        return terminalOrigen;
    }

}
