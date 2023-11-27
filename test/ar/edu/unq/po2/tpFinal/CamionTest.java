package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CamionTest {
    private Camion camion;

    @Before
    public void setUp() {
        Chofer chofer = mock(Chofer.class);
        when(chofer.getNombre()).thenReturn("Juan");

        Container contenedor1 = mock(Container.class);
        Container contenedor2 = mock(Container.class);

        this.camion = new Camion(chofer);

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

    @Test
    public void agregarContenedor() {
        Camion camionMock = mock(Camion.class);
        Container contenedor = mock(Container.class);
        camionMock.agregarContenedor(contenedor);
        verify(camionMock).agregarContenedor(contenedor);
    }

}
