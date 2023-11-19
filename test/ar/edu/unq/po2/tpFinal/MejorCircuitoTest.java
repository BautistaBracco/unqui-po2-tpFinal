package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.terminal.MenorCantidadDeTerminalesStrategy;
import ar.edu.unq.po2.tpFinal.terminal.MenorPrecioStrategy;
import ar.edu.unq.po2.tpFinal.terminal.MenorTiempoStrategy;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MejorCircuitoTest {
    MenorCantidadDeTerminalesStrategy menorCantidadDeTerminalesStrategy;
    MenorPrecioStrategy menorPrecioStrategy;
    MenorTiempoStrategy menorTiempoStrategy;
    List<CircuitoMaritimoInterface> circuitosMaritimos;
    TerminalInterface terminalOrigen;
    TerminalInterface terminalDestino;

    @Before
    public void setUp() {
        this.circuitosMaritimos = new ArrayList<>();
        this.terminalOrigen = mock(TerminalInterface.class);
        this.terminalDestino = mock(TerminalInterface.class);

        circuitosMaritimos.add(this.mockCircuitoMaritimo(Duration.ofDays(10), 1, 1000));
        circuitosMaritimos.add(this.mockCircuitoMaritimo(Duration.ofDays(2), 4, 2000));
        circuitosMaritimos.add(this.mockCircuitoMaritimo(Duration.ofDays(7), 3, 300));

        this.menorCantidadDeTerminalesStrategy = new MenorCantidadDeTerminalesStrategy(circuitosMaritimos,
                terminalOrigen,
                terminalDestino);
        this.menorPrecioStrategy = new MenorPrecioStrategy(circuitosMaritimos, terminalOrigen, terminalDestino);
        this.menorTiempoStrategy = new MenorTiempoStrategy(circuitosMaritimos, terminalOrigen, terminalDestino);

    }

    @Test
    public void testMejorCircuitoPorMenorCantidadDeTerminales() {
        assertEquals(this.circuitosMaritimos.get(0), this.menorCantidadDeTerminalesStrategy.getMejorCircuito());
    }

    @Test
    public void testMejorCircuitoPorMenorPrecio() {
        assertEquals(this.circuitosMaritimos.get(2), this.menorPrecioStrategy.getMejorCircuito());
    }

    @Test
    public void testMejorCircuitoPorMenorTiempo() {
        assertEquals(this.circuitosMaritimos.get(1), this.menorTiempoStrategy.getMejorCircuito());
    }


    private CircuitoMaritimoInterface mockCircuitoMaritimo(
            Duration tiempoEntreTramos, Integer cantidadDeTerminales, Integer precioEntreTramos
    ) {
        CircuitoMaritimoInterface circuitoMaritimo = mock(CircuitoMaritimoInterface.class);

        when(circuitoMaritimo.tiempoEntreTramos(this.terminalOrigen,
                this.terminalDestino)).thenReturn(tiempoEntreTramos);

        when(circuitoMaritimo.cantidadDeTramosEntre(this.terminalOrigen, this.terminalDestino)).thenReturn(
                cantidadDeTerminales);

        when(circuitoMaritimo.precioEntreTramos(this.terminalOrigen,
                this.terminalDestino)).thenReturn(precioEntreTramos);

        return circuitoMaritimo;
    }
}
