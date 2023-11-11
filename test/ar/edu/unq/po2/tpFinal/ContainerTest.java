package ar.edu.unq.po2.tpFinal;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.container.ContainerSeco;
import ar.edu.unq.po2.tpFinal.container.ContainerTanque;

public class ContainerTest {

	private Container containerReefer;
	private Container containerSeco;
	private Container containerTanque;
	
	@Before
	public void setUp() {
		containerReefer = new ContainerReefer(5, 15, 5, 150, 500);
		containerSeco = new ContainerSeco(4, 14, 4, 100);
		containerTanque = new ContainerTanque(6, 16, 6, 125);
	}
	
	@Test
	public void testContainerSeco() {
		assertEquals(224, containerSeco.metrosCubicos());
		assertEquals(100, containerSeco.getPesoTotal());
		assertEquals(0, containerSeco.getKWPorHoras());
	}
	
	@Test 
	public void testContainerTanque() {
		assertEquals(576, containerTanque.metrosCubicos());
		assertEquals(125, containerTanque.getPesoTotal());
		assertEquals(0, containerTanque.getKWPorHoras());
	}
	
	@Test
	public void testContainerReefer() {
		assertEquals(375, containerReefer.metrosCubicos());
		assertEquals(150, containerReefer.getPesoTotal());
		assertEquals(500, containerReefer.getKWPorHoras());
	}
	
}