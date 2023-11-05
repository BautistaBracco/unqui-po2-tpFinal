package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.circuito.TramoInterface;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CircuitoMaritimoTest {

    private CircuitoMaritimo circuitoMaritimo;


    @Before
    public void setUp() {
        this.circuitoMaritimo = new CircuitoMaritimo();
        TramoInterface tramo1 = this.mockTramo(this.mockTerminal("Buenos Aires"), this.mockTerminal("Montevideo"), 100, 1);
        TramoInterface tramo2 = this.mockTramo(this.mockTerminal("Montevideo"), this.mockTerminal("Bahia"), 100, 1);
        TramoInterface tramo3 = this.mockTramo(this.mockTerminal("Bahia"), this.mockTerminal("Rio de Janeiro"), 100, 1);
        TramoInterface tramo4 = this.mockTramo(this.mockTerminal("Rio de Janeiro"), this.mockTerminal("Buenos Aires"), 100, 1);

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
                     this.circuitoMaritimo
                             .tramosEntre(this.mockTerminal("Buenos Aires"), this.mockTerminal("Rio de Janeiro"))
                             .size());
    }

    @Test
    public void testPrecioTotalDelCircuito() {
        assertEquals(400, this.circuitoMaritimo.precioTotalDelCircuito());
    }

    @Test
    public void testPrecioEntreBsAsYMontevideo() {
        assertEquals(100,
                     this.circuitoMaritimo.precioEntreTramos(this.mockTerminal("Buenos Aires"),
                                                             this.mockTerminal("Montevideo")));
    }

    @Test
    public void testTiempoTotalDelCircuito() {
        assertEquals(4, this.circuitoMaritimo.tiempoTotalDelCircuito());
    }

    @Test
    public void testTiempoEntreBsAsYMontevideo() {
        assertEquals(1,
                     this.circuitoMaritimo.tiempoEntreTramos(this.mockTerminal("Buenos Aires"),
                                                             this.mockTerminal("Montevideo")));
    }


    private TramoInterface mockTramo(TerminalInterface origen, TerminalInterface destino, int precio, int tiempo) {
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
