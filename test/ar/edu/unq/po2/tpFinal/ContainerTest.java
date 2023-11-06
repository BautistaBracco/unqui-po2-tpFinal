package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.container.ContainerSeco;
import ar.edu.unq.po2.tpFinal.container.ContainerTanque;

/*
 * mock(nameClass.class)
 * spy(new ArrayList<Receta>())
 * orden.verify(spyListaDeRecetas).add(dummyReceta)
 * when(recetaAptaCeliaco.costoTotal()).thenReturn(30);
 */
class ContainerTest {

	private Container containerReefer;
	private Container containerSeco;
	private Container containerTanque;
	
	@BeforeEach
	public void setUp() {
		containerReefer = new ContainerReefer(5, 15, 5, 150, 500);
		containerSeco = new ContainerSeco(4, 14, 4, 100);
		containerTanque = new ContainerTanque(6, 16, 6, 125);
	}
	
	@Test
	void testContainer() {
//		ContainerSeco y ContainerTanque son lo mismo test que reefer en cuanto al calculo de metrosCubicos y peso.
		assertEquals(375, containerSeco.metrosCubicos());		
		assertEquals(125, containerTanque.getPesoTotal());
	}
	
	@Test
	void testContainerReefer() {
//		Se hace un casteo para utilizar el metodo de la clase ContainerReefer.
		assertEquals(500, ((ContainerReefer) containerReefer).getKWPorHoras());
	}
	
}