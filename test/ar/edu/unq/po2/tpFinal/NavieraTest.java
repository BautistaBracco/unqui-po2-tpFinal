package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.viaje.ViajesInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class NavieraTest {

    private Naviera naviera;

    @Before
    public void setUp() {
        this.naviera = new Naviera();

        this.naviera.agregarBuque(mock(BuqueInterface.class));
        this.naviera.agregarBuque(mock(BuqueInterface.class));
        this.naviera.agregarBuque(mock(BuqueInterface.class));

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
        assertEquals(2, this.naviera.getCircuitos().size());
    }

    @Test
    public void testCantidadDeViajes() {
        assertEquals(4, this.naviera.getViajes().size());
    }

}
