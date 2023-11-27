package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ChoferTest {
    private Chofer chofer;

    @Before
    public void setUp() {
        this.chofer = new Chofer("Juan");
    }

    @Test
    public void testNombre() {
        assertEquals("Juan", this.chofer.getNombre());
    }
}
