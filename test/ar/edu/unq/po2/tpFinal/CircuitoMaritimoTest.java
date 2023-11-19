package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.circuito.TramoInterface;
import ar.edu.unq.po2.tpFinal.terminal.TerminalInterface;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CircuitoMaritimoTest {

    private CircuitoMaritimo circuitoMaritimo;
    private TerminalInterface terminalBuenosAires;
    private TerminalInterface terminalMontevideo;
    private TerminalInterface terminalBahia;
    private TerminalInterface terminalRioDeJaneiro;


    @Before
    public void setUp() {
        this.circuitoMaritimo = new CircuitoMaritimo();
        this.terminalBuenosAires = this.mockTerminal("Buenos Aires");
        this.terminalMontevideo = this.mockTerminal("Montevideo");
        this.terminalBahia = this.mockTerminal("Bahia");
        this.terminalRioDeJaneiro = this.mockTerminal("Rio de Janeiro");

        TramoInterface tramo1 = this.mockTramo(this.terminalBuenosAires,
                this.terminalMontevideo,
                100,
                Duration.ofDays(1));

        TramoInterface tramo2 = this.mockTramo(this.terminalMontevideo, this.terminalBahia, 100, Duration.ofDays(4));
        TramoInterface tramo3 = this.mockTramo(this.terminalBahia, this.terminalRioDeJaneiro, 100, Duration.ofDays(3));
        TramoInterface tramo4 = this.mockTramo(this.terminalRioDeJaneiro,
                this.terminalBuenosAires,
                100,
                Duration.ofDays(10));

        this.circuitoMaritimo.agregarTramo(tramo1);
        this.circuitoMaritimo.agregarTramo(tramo2);
        this.circuitoMaritimo.agregarTramo(tramo3);
        this.circuitoMaritimo.agregarTramo(tramo4);

        BuqueInterface buque1 = mock(BuqueInterface.class);
        BuqueInterface buque2 = mock(BuqueInterface.class);
        BuqueInterface buque3 = mock(BuqueInterface.class);

        this.circuitoMaritimo.agregarBuque(buque1);
        this.circuitoMaritimo.agregarBuque(buque2);
        this.circuitoMaritimo.agregarBuque(buque3);
    }

    @Test
    public void testCantidadDeBuques() {
        assertEquals(3, this.circuitoMaritimo.cantidadDeBuques());
    }

    @Test
    public void testCantidadDeTramos() {
        assertEquals(4, this.circuitoMaritimo.cantidadDeTramos());
    }

    @Test
    public void testTramosEntreBsAsYRioDeJaneiro() {
        assertEquals(3,
                this.circuitoMaritimo.cantidadDeTramosEntre(this.terminalBuenosAires, this.terminalRioDeJaneiro));
    }

    @Test
    public void testPrecioTotalDelCircuito() {
        assertEquals(400, this.circuitoMaritimo.precioTotalDelCircuito());
    }

    @Test
    public void testPrecioEntreBsAsYMontevideo() {
        assertEquals(100, this.circuitoMaritimo.precioEntreTramos(this.terminalBuenosAires, this.terminalMontevideo));
    }

    @Test
    public void testTiempoTotalDelCircuito() {
        assertEquals(Duration.ofDays(18), this.circuitoMaritimo.tiempoTotalDelCircuito());
    }

    @Test
    public void testTiempoEntreBsAsYMontevideo() {
        assertEquals(Duration.ofDays(1),
                this.circuitoMaritimo.tiempoEntreTramos(this.terminalBuenosAires, this.terminalMontevideo));
    }

    @Test
    public void existeTerminal() {
        assertEquals(true, this.circuitoMaritimo.existeTerminal(this.terminalBuenosAires));
    }


    private TramoInterface mockTramo(TerminalInterface origen, TerminalInterface destino, int precio, Duration tiempo) {

        TramoInterface tramo = mock(TramoInterface.class);
        when(tramo.getPuertoOrigen()).thenReturn(origen);
        when(tramo.getPuertoDestino()).thenReturn(destino);
        when(tramo.getPrecio()).thenReturn(precio);
        when(tramo.getTiempo()).thenReturn(tiempo);
        return tramo;
    }

    private TerminalInterface mockTerminal(String nombre) {
        TerminalInterface terminal = mock(TerminalInterface.class);
        when(terminal.getNombre()).thenReturn(nombre);
        return terminal;
    }
}
