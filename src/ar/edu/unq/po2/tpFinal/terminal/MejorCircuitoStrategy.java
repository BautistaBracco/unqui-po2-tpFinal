package ar.edu.unq.po2.tpFinal.terminal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;

import java.util.List;

public interface MejorCircuitoStrategy {

    CircuitoMaritimo getMejorCircuitoPara(
            Terminal origen, Terminal destino, List<CircuitoMaritimo> circuitosMaritimos
    );

}

