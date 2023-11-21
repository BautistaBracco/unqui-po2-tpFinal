package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
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

        CircuitoMaritimoInterface circuitoMaritimo = mock(CircuitoMaritimoInterface.class);
        when(circuitoMaritimo.tiempoEntreTramos(this.terminalOrigen,
                this.terminalDestino)).thenReturn(Duration.ofDays(1));
        when(circuitoMaritimo.existeTerminal(this.terminalDestino)).thenReturn(true);

        this.viaje = new Viaje(LocalDateTime.of(2023, 10, 10, 10, 10),
                this.terminalOrigen,
                circuitoMaritimo,
                this.buque);
    }

    @Test
    public void testFechaDeLlegada() {
        assertEquals(LocalDateTime.of(2023, 10, 11, 10, 10), this.viaje.getFechaDeLlegada(this.terminalDestino));
    }

    @Test
    public void terminalOrigenTest() {
        assertEquals(this.terminalOrigen, this.viaje.getTerminalOrigen());
    }

    @Test
    public void buqueTest() {
        assertEquals(this.buque, this.viaje.getBuque());
    }

    @Test
    public void tiempoDeViajeTest() {
        assertEquals(Duration.ofDays(1), this.viaje.getTiempoDeViaje(this.terminalDestino));
    }

    @Test
    public void existeDestinoTest() {
        assertEquals(true, this.viaje.existeDestino(this.terminalDestino));
    }

    private TerminalInterface mockTerminal() {
        return mock(TerminalInterface.class);
    }

    private BuqueInterface mockBuque() {
        return mock(BuqueInterface.class);
    }

}
