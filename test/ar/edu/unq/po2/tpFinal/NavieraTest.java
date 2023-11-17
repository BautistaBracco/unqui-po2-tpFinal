package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import ar.edu.unq.po2.tpFinal.viaje.ViajesInterface;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NavieraTest {

    private Naviera naviera;
    private TerminalInterface terminalBuenosAires;
    private TerminalInterface terminalMontevideo;

    @Before
    public void setUp() {
        this.naviera = new Naviera();
        this.terminalBuenosAires = mock(TerminalInterface.class);
        this.terminalMontevideo = mock(TerminalInterface.class);

        this.naviera.agregarBuque(mock(BuqueInterface.class));
        this.naviera.agregarBuque(mock(BuqueInterface.class));
        this.naviera.agregarBuque(mock(BuqueInterface.class));

        CircuitoMaritimoInterface circuito = mock(CircuitoMaritimoInterface.class);
        when(circuito.existeTerminal(this.terminalBuenosAires)).thenReturn(true);
        when(circuito.existeTerminal(this.terminalMontevideo)).thenReturn(true);
        when(circuito.tiempoEntreTramos(this.terminalBuenosAires,
                this.terminalMontevideo)).thenReturn(Duration.ofDays(3));

        this.naviera.agregarCircuito(circuito);
        this.naviera.agregarCircuito(mock(CircuitoMaritimoInterface.class));
        this.naviera.agregarCircuito(mock(CircuitoMaritimoInterface.class));
        this.naviera.agregarCircuito(mock(CircuitoMaritimoInterface.class));

        this.naviera.agregarViaje(mock(ViajesInterface.class));
        this.naviera.agregarViaje(mock(ViajesInterface.class));
        this.naviera.agregarViaje(mock(ViajesInterface.class));
        this.naviera.agregarViaje(mock(ViajesInterface.class));

    }

    @Test
    public void testCantidadDeBuques() {
        assertEquals(3, this.naviera.getBuques().size());
    }

    @Test
    public void testCantidadDeCircuitos() {
        assertEquals(4, this.naviera.getCircuitos().size());
    }

    @Test
    public void testCantidadDeViajes() {
        assertEquals(4, this.naviera.getViajes().size());
    }

    @Test
    public void testCircuitosConTerminalesDeOrigenYDestino() {
        assertEquals(1,
                this.naviera
                        .getCircuitosConTerminalesDeOrigenYDestino(this.terminalBuenosAires, this.terminalMontevideo)
                        .size());
    }

    @Test
    public void testTiempoDeViaje() {
        assertEquals(Duration.ofDays(3),
                this.naviera.getTiempoDeViaje(this.terminalBuenosAires, this.terminalMontevideo));
    }

}
