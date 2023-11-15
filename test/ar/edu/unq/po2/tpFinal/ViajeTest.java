package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViajeTest {
    private Viaje viaje;
    private TerminalInterface terminalOrigen;
    private TerminalInterface terminalDestino;
    private BuqueInterface buque;

    @Before
    public void setUp() {
        this.terminalOrigen = this.mockTerminal();
        this.terminalDestino = this.mockTerminal();
        this.buque = this.mockBuque();
        this.viaje = new Viaje(LocalDateTime.of(2023, 10, 10, 10, 10),
                               this.terminalOrigen,
                               this.mockCircuitoMaritimo(),
                               this.buque);
    }

    @Test
    public void testGetFechaDeLlegada() {
        assertEquals(LocalDateTime.of(2023, 10, 11, 10, 10), this.viaje.getFechaDeLlegada(this.terminalDestino));
    }

    @Test
    public void getTerminalOrigen() {
        assertEquals(this.terminalOrigen, this.viaje.getTerminalOrigen());
    }

    @Test
    public void getBuque() {
        assertEquals(this.buque, this.viaje.getBuque());
    }

    private TerminalInterface mockTerminal() {
        return mock(TerminalInterface.class);
    }

    private BuqueInterface mockBuque() {
        return mock(BuqueInterface.class);
    }

    private CircuitoMaritimoInterface mockCircuitoMaritimo() {
        CircuitoMaritimoInterface circuitoMaritimo = mock(CircuitoMaritimoInterface.class);
        when(circuitoMaritimo.tiempoEntreTramos(this.terminalOrigen,
                                                this.terminalDestino)).thenReturn(Duration.ofDays(1));
        return circuitoMaritimo;
    }
}
