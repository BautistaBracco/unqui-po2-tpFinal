package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.container.ContainerInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CamionTest {
    private Camion camion;

    @Before
    public void setUp() {
        ChoferInterface chofer = mock(ChoferInterface.class);
        when(chofer.getNombre()).thenReturn("Juan");

        ContainerInterface contenedor1 = mock(ContainerInterface.class);
        ContainerInterface contenedor2 = mock(ContainerInterface.class);

        this.camion = new Camion(chofer, "abcdadas");

        this.camion.agregarContenedor(contenedor1);
        this.camion.agregarContenedor(contenedor2);
    }

    @Test
    public void testChofer() {
        assertEquals("Juan", this.camion.getChofer().getNombre());
    }

    @Test
    public void testCantidadDeContenedores() {
        assertEquals(2, this.camion.cantidadDeContenedores());
    }

}
