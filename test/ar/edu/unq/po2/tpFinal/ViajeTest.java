package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViajeTest {
    private Viaje viaje;
    private Terminal terminalOrigen;
    private Terminal terminalDestino;
    private Buque buque;

    @Before
    public void setUp() {
        this.terminalOrigen = this.mockTerminal("Buenos Aires");
        this.terminalDestino = this.mockTerminal("Montevideo");
        this.buque = this.mockBuque();

        CircuitoMaritimo circuitoMaritimoMock = mock(CircuitoMaritimo.class);
        when(circuitoMaritimoMock.tiempoEntreTramos(this.terminalOrigen,
                this.terminalDestino)).thenReturn(Duration.ofDays(1));
        when(circuitoMaritimoMock.existeTerminal(this.terminalDestino)).thenReturn(true);
        when(circuitoMaritimoMock.precioEntreTramos(this.terminalOrigen, this.terminalDestino)).thenReturn(100);

        this.viaje = new Viaje(LocalDateTime.of(2023, 10, 10, 10, 10),
                this.terminalOrigen,
                circuitoMaritimoMock,
                this.buque);
    }

    @Test
    public void fechaDeLlegada() {
        assertEquals(LocalDateTime.of(2023, 10, 11, 10, 10), this.viaje.getFechaDeLlegada(this.terminalDestino));
    }

    @Test
    public void fechaDeSalidaTest() {
        assertEquals(LocalDateTime.of(2023, 10, 10, 10, 10), this.viaje.getFechaDeSalida());
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
        assertTrue(this.viaje.existeDestino(this.terminalDestino));
    }

    @Test
    public void tieneMismaTerminalOrigenTest() {
        assertTrue(this.viaje.tieneMismaTerminalOrigen(this.terminalOrigen));
    }

    @Test
    public void costoDeViajeTest() {
        assertEquals(100, this.viaje.costoDeViaje(this.terminalDestino));
    }


    private Terminal mockTerminal(String nombre) {
        Terminal terminal = mock(Terminal.class);
        when(terminal.getNombre()).thenReturn(nombre);
        return terminal;
    }

    private Buque mockBuque() {
        return mock(Buque.class);
    }

}
