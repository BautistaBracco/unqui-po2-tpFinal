package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.EmpresaTransportista;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmpresaTransportistaTest {

    private EmpresaTransportista empresaTransportista;

    @Before
    public void setUp() {
        this.empresaTransportista = new EmpresaTransportista("324");
        Chofer chofer1 = mockChofer("Juan");
        Chofer chofer2 = mockChofer("Pedro");
        Chofer chofer3 = mockChofer("Alberto");
        this.empresaTransportista.agregarChofer(chofer1);
        this.empresaTransportista.agregarChofer(chofer2);
        this.empresaTransportista.agregarChofer(chofer3);

        Camion camion1 = mockCamion(chofer1);
        Camion camion2 = mockCamion(chofer2);
        this.empresaTransportista.agregarCamion(camion1);
        this.empresaTransportista.agregarCamion(camion2);


    }


    @Test
    public void testCantidadDeChoferes() {
        assertEquals(3, this.empresaTransportista.cantidadDeChoferes());
    }

    @Test
    public void testCantidadDeCamiones() {
        assertEquals(2, this.empresaTransportista.cantidadDeCamiones());
    }

    private Camion mockCamion(Chofer chofer) {
        Camion camion = mock(Camion.class);
        when(camion.getChofer()).thenReturn(chofer);
        return camion;
    }

    private Chofer mockChofer(String nombre) {
        Chofer chofer = mock(Chofer.class);
        when(chofer.getNombre()).thenReturn(nombre);
        return chofer;
    }


}
