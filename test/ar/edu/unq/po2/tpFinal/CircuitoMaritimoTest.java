package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.circuito.Tramo;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class CircuitoMaritimoTest {

    private CircuitoMaritimo circuitoMaritimo;
    private Terminal terminalBuenosAires;
    private Terminal terminalMontevideo;
    private Terminal terminalBahia;
    private Terminal terminalRioDeJaneiro;


    @Before
    public void setUp() {
        this.circuitoMaritimo = new CircuitoMaritimo();
        this.terminalBuenosAires = this.mockTerminal("Buenos Aires");
        this.terminalMontevideo = this.mockTerminal("Montevideo");
        this.terminalBahia = this.mockTerminal("Bahia");
        this.terminalRioDeJaneiro = this.mockTerminal("Rio de Janeiro");

        Tramo tramo1 = this.mockTramo(this.terminalBuenosAires, this.terminalMontevideo, 100, Duration.ofDays(1));
        Tramo tramo2 = this.mockTramo(this.terminalMontevideo, this.terminalBahia, 100, Duration.ofDays(4));
        Tramo tramo3 = this.mockTramo(this.terminalBahia, this.terminalRioDeJaneiro, 100, Duration.ofDays(3));
        Tramo tramo4 = this.mockTramo(this.terminalRioDeJaneiro, this.terminalBuenosAires, 100, Duration.ofDays(10));

        this.circuitoMaritimo.agregarTramo(tramo1);
        this.circuitoMaritimo.agregarTramo(tramo2);
        this.circuitoMaritimo.agregarTramo(tramo3);
        this.circuitoMaritimo.agregarTramo(tramo4);

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

    @Test
    public void agregarTramo() {
        CircuitoMaritimo circuitoMaritimoMock = mock(CircuitoMaritimo.class);
        Tramo tramo = mock(Tramo.class);
        circuitoMaritimoMock.agregarTramo(tramo);
        verify(circuitoMaritimoMock).agregarTramo(tramo);
    }


    private Tramo mockTramo(Terminal origen, Terminal destino, int precio, Duration tiempo) {

        Tramo tramo = mock(Tramo.class);
        when(tramo.getPuertoOrigen()).thenReturn(origen);
        when(tramo.getPuertoDestino()).thenReturn(destino);
        when(tramo.getPrecio()).thenReturn(precio);
        when(tramo.getTiempo()).thenReturn(tiempo);
        return tramo;
    }

    private Terminal mockTerminal(String nombre) {
        Terminal terminal = mock(Terminal.class);
        when(terminal.getNombre()).thenReturn(nombre);
        return terminal;
    }
}
