package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class ViajeTest {
    private Viaje viaje;

    @Before
    public void setUp() {
        this.viaje = new Viaje(LocalDateTime.of(2021, 10, 10, 10, 10),
                this.mockTerminal(),
                this.mockCircuitoMaritimo(),
                mock(BuqueInterface.class));
    }

    @Test
    public void testGetFechaDeLlegada() {
        // TODO
    }

    private TerminalInterface mockTerminal() {
        return mock(TerminalInterface.class);
    }

    private CircuitoMaritimoInterface mockCircuitoMaritimo() {
        return mock(CircuitoMaritimoInterface.class);
    }
}
