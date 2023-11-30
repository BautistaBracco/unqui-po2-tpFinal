package ar.edu.unq.po2.tpFinal;

import ar.edu.unq.po2.tpFinal.busquedaMaritima.RutaMaritima;
import ar.edu.unq.po2.tpFinal.busquedaMaritima.OperadorLogicoAND;
import ar.edu.unq.po2.tpFinal.busquedaMaritima.Filtro;
import ar.edu.unq.po2.tpFinal.busquedaMaritima.OperadorLogicoOR;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OperadorLogicoTest {
    private Filtro filtroTrue;
    private Filtro filtroFalse;
    private RutaMaritima rutaMaritima;

    @Before
    public void setUp() {

        this.rutaMaritima = mock(RutaMaritima.class);
        this.filtroTrue = this.mockFiltro(true);
        this.filtroFalse = this.mockFiltro(false);
    }

    @Test
    public void testGetters() {
        OperadorLogicoOR operadorLogicoOR = new OperadorLogicoOR(this.filtroTrue, this.filtroFalse);
        OperadorLogicoAND operadorLogicoAND = new OperadorLogicoAND(this.filtroTrue, this.filtroFalse);
        assertEquals(this.filtroTrue, operadorLogicoAND.getFiltroIzquierda());
        assertEquals(this.filtroFalse, operadorLogicoAND.getFiltroDerecha());
    }

    @Test
    public void testAplicarAND() {
        OperadorLogicoAND operadorLogicoANDTrue = new OperadorLogicoAND(this.filtroTrue, this.filtroTrue);
        OperadorLogicoAND operadorLogicoANDFalse = new OperadorLogicoAND(this.filtroTrue, this.filtroFalse);
        assertTrue(operadorLogicoANDTrue.aplicar(this.rutaMaritima));
        assertFalse(operadorLogicoANDFalse.aplicar(this.rutaMaritima));
    }

    @Test
    public void testAplicarOR() {
        OperadorLogicoOR operadorLogicoORTrue = new OperadorLogicoOR(this.filtroTrue, this.filtroFalse);
        OperadorLogicoOR operadorLogicoORFalse = new OperadorLogicoOR(this.filtroFalse, this.filtroFalse);
        assertTrue(operadorLogicoORTrue.aplicar(this.rutaMaritima));
        assertFalse(operadorLogicoORFalse.aplicar(this.rutaMaritima));
    }

    private Filtro mockFiltro(boolean resultado) {
        Filtro filtro = mock(Filtro.class);
        when(filtro.aplicar(this.rutaMaritima)).thenReturn(resultado);
        return filtro;
    }

}