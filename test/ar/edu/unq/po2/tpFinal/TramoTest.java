package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.Tramo;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;

public class TramoTest {
    private Tramo tramo;
    private Terminal terminalOrigen;
    private Terminal terminalDestino;


    @Before
    public void setUp() {
        this.tramo = new Tramo(this.terminalOrigen, this.terminalDestino, 100, Duration.ofDays(5));
    }

    @Test
    public void testGetPuertoOrigen() {
        assertEquals(this.terminalOrigen, this.tramo.getPuertoOrigen());
    }

    @Test
    public void testGetPuertoDestino() {
        assertEquals(this.terminalDestino, this.tramo.getPuertoDestino());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(100, this.tramo.getPrecio());
    }

    @Test
    public void testGetTiempo() {
        assertEquals(Duration.ofDays(5), this.tramo.getTiempo());
    }
}
