package ar.edu.unq.po2.tpFinal;


import ar.edu.unq.po2.tpFinal.busquedaMaritima.*;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FiltroTest {
    private RutaMaritima rutaMaritima;
    private Terminal terminal;
    private LocalDateTime ahora;

    @Before
    public void setUp() {
        ahora = LocalDateTime.now();

        terminal = mock(Terminal.class);
        when(terminal.getNombre()).thenReturn("Puerto Madero");

        rutaMaritima = mock(RutaMaritima.class);
        when(rutaMaritima.getFechaDeSalida()).thenReturn(ahora);
        when(rutaMaritima.getFechaDeLlegada()).thenReturn(ahora.plus(Duration.ofDays(1)));
        when(rutaMaritima.getPuertoDestino()).thenReturn(terminal);
    }

    @Test
    public void testFiltroFechaLlegadaMenor() {
        FiltroFechaMenorLlegada filtroFechaMenorLlegada = new FiltroFechaMenorLlegada(ahora.plus(Duration.ofDays(2)));
        assertTrue(filtroFechaMenorLlegada.aplicar(rutaMaritima));
    }

    @Test
    public void testFiltroFechaLlegadaMayor() {
        FiltroFechaMayorLlegada filtroFechaMayorLlegada = new FiltroFechaMayorLlegada(ahora);
        assertTrue(filtroFechaMayorLlegada.aplicar(rutaMaritima));
    }

    @Test
    public void testFiltroFechaSalidaMenor() {
        FiltroFechaMenorSalida filtroFechaMenorSalida = new FiltroFechaMenorSalida(ahora.plus(Duration.ofDays(2)));
        assertTrue(filtroFechaMenorSalida.aplicar(rutaMaritima));
    }

    @Test
    public void testFiltroFechaSalidaMayor() {
        FiltroFechaMayorSalida filtroFechaMayorSalida = new FiltroFechaMayorSalida(ahora.minusDays(2));
        assertTrue(filtroFechaMayorSalida.aplicar(rutaMaritima));
    }

    @Test
    public void testFiltroFechaSalidaIgual() {
        FiltroFechaIgualSalida filtroFechaIgualSalida = new FiltroFechaIgualSalida(ahora);
        assertTrue(filtroFechaIgualSalida.aplicar(rutaMaritima));
    }

    @Test
    public void testFiltroFechaLlegadaIgual() {
        FiltroFechaIgualLlegada filtroFechaIgualLlegada = new FiltroFechaIgualLlegada(ahora.plus(Duration.ofDays(1)));
        assertTrue(filtroFechaIgualLlegada.aplicar(rutaMaritima));
    }

    @Test
    public void testFiltroPuerto() {
        FiltroPuerto filtroPuerto = new FiltroPuerto("Puerto Madero");
        assertTrue(filtroPuerto.aplicar(rutaMaritima));
    }

}
