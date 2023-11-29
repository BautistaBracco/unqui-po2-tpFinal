package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.busquedaMaritima.RutaMaritima;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class RutaMaritimaTest {
    private RutaMaritima rutaMaritima;
    private Terminal terminal;
    private LocalDateTime ahora;

    @Before
    public void setUp() {
        terminal = mock(Terminal.class);
        ahora = LocalDateTime.now();
        rutaMaritima = new RutaMaritima(terminal, ahora, ahora.plus(Duration.ofDays(1)));
    }

    @Test
    public void testGetters() {
        assertEquals(terminal, rutaMaritima.getPuertoDestino());
        assertEquals(ahora, rutaMaritima.getFechaDeSalida());
        assertEquals(ahora.plus(Duration.ofDays(1)), rutaMaritima.getFechaDeLlegada());
    }
}
