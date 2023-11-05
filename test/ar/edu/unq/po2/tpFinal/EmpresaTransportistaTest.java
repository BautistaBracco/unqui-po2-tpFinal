package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.empresaTransportista.CamionInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;
import ar.edu.unq.po2.tpFinal.empresaTransportista.EmpresaTransportista;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmpresaTransportistaTest {

    private EmpresaTransportista empresaTransportista;

    @Before
    public void setUp() {
        this.empresaTransportista = new EmpresaTransportista("324");
        ChoferInterface chofer1 = mockChofer("Juan");
        ChoferInterface chofer2 = mockChofer("Pedro");
        ChoferInterface chofer3 = mockChofer("Alberto");
        this.empresaTransportista.agregarChofer(chofer1);
        this.empresaTransportista.agregarChofer(chofer2);
        this.empresaTransportista.agregarChofer(chofer3);

        CamionInterface camion1 = mockCamion(chofer1);
        CamionInterface camion2 = mockCamion(chofer2);
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

    private CamionInterface mockCamion(ChoferInterface chofer) {
        CamionInterface camion = mock(CamionInterface.class);
        when(camion.getChofer()).thenReturn(chofer);
        return camion;
    }

    private ChoferInterface mockChofer(String nombre) {
        ChoferInterface chofer = mock(ChoferInterface.class);
        when(chofer.getNombre()).thenReturn(nombre);
        return chofer;
    }


}
