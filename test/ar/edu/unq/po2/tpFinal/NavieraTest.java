package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimo;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NavieraTest {

    private Naviera naviera;
    private Terminal terminalBuenosAires;
    private Terminal terminalMontevideo;
    private LocalDateTime fecha;

    @Before
    public void setUp() {
        this.fecha = LocalDateTime.now().plus(Duration.ofDays(1));
        this.naviera = new Naviera();
        this.terminalBuenosAires = mock(Terminal.class);
        this.terminalMontevideo = mock(Terminal.class);

        this.naviera.agregarBuque(mock(Buque.class));
        this.naviera.agregarBuque(mock(Buque.class));
        this.naviera.agregarBuque(mock(Buque.class));

        CircuitoMaritimo circuito = mock(CircuitoMaritimo.class);
        when(circuito.existeTerminal(this.terminalBuenosAires)).thenReturn(true);
        when(circuito.existeTerminal(this.terminalMontevideo)).thenReturn(true);
        when(circuito.tiempoEntreTramos(this.terminalBuenosAires,
                this.terminalMontevideo)).thenReturn(Duration.ofDays(3));

        this.naviera.agregarCircuito(circuito);
        this.naviera.agregarCircuito(mock(CircuitoMaritimo.class));
        this.naviera.agregarCircuito(mock(CircuitoMaritimo.class));
        this.naviera.agregarCircuito(mock(CircuitoMaritimo.class));

        Viaje unViaje = mock(Viaje.class);
        when(unViaje.tieneMismaTerminalOrigen(this.terminalBuenosAires)).thenReturn(true);
        when(unViaje.existeDestino(this.terminalMontevideo)).thenReturn(true);
        when(unViaje.getFechaDeSalida()).thenReturn(fecha);

        this.naviera.agregarViaje(unViaje);
        this.naviera.agregarViaje(mock(Viaje.class));
        this.naviera.agregarViaje(mock(Viaje.class));
        this.naviera.agregarViaje(mock(Viaje.class));

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

    @Test
    public void testFechaDeProximoViaje() {
        assertEquals(fecha,
                this.naviera.getFechaDeProximoViaje(this.terminalBuenosAires,
                        this.terminalMontevideo,
                        LocalDateTime.now()));
    }

}
