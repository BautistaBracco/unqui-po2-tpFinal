package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChoferTest {
    private ChoferInterface chofer;

    @Before
    public void setUp() {
        this.chofer = new Chofer("Juan");
    }

    @Test
    public void testNombre() {
        assertEquals("Juan", this.chofer.getNombre());
    }
}
