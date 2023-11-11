package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.container.ContainerSeco;
import ar.edu.unq.po2.tpFinal.container.ContainerTanque;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioAlmacenamiento;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioElectricidad;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioLavado;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioPesado;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * mock(nameClass.class)
 * spy(new ArrayList<Receta>())
 * orden.verify(spyListaDeRecetas).add(dummyReceta)
 * when(recetaAptaCeliaco.costoTotal()).thenReturn(30);
 */

public class ServicioContainerTest {
	
	private ServicioContainer servicioContainerAlmacenamiento;
	private ServicioContainer servicioContainerLavado;
	private ServicioContainer servicioContainerPesado;
	private ServicioContainer servicioContainerElectricidad;
	
	@Before
	public void setUp() {
		LocalDateTime fechaHoraLlegada = mock(LocalDateTime.class);
		
		Container containerSeco = mock(ContainerSeco.class);
		when(containerSeco.metrosCubicos()).thenReturn(60);
		
		Container containerReefer = mock(ContainerReefer.class);
		when(containerReefer.getKWPorHoras()).thenReturn(40);
		
		
		Container containerTanque = mock(ContainerTanque.class);
		when(containerTanque.metrosCubicos()).thenReturn(60);
		
		servicioContainerElectricidad = new ServicioElectricidad(containerReefer, fechaHoraLlegada);
		servicioContainerPesado = new ServicioPesado(containerTanque, fechaHoraLlegada);
		servicioContainerLavado = new ServicioLavado(containerSeco, fechaHoraLlegada);
		servicioContainerAlmacenamiento = new ServicioAlmacenamiento(containerSeco, fechaHoraLlegada, 50);
		
	}
	
	@Test
	public void testContainer() {
		assertEquals(60, servicioContainerAlmacenamiento.getContainer().metrosCubicos());
		assertEquals(40, servicioContainerElectricidad.getContainer().getKWPorHoras());
	}
	
	@Test
	public void testServicioContainer() {
		assertEquals(0,0);
	}

}