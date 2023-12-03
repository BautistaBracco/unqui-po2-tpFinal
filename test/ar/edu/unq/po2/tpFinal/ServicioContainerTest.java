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


public class ServicioContainerTest {
	
	private ServicioContainer servicioContainerAlmacenamiento;
	private ServicioContainer servicioContainerLavadoReefer;
	private ServicioContainer servicioContainerLavadoSeco;
	private ServicioContainer servicioContainerPesado;
	private ServicioContainer servicioContainerElectricidad;
	
	@Before
	public void setUp() {
		LocalDateTime fechaHoraInicial = LocalDateTime.of(2010, 11, 15, 16, 0);
		LocalDateTime fechaHoraFinal = LocalDateTime.of(2010, 12, 15, 16, 0);
		
		Container containerSeco = mock(ContainerSeco.class);
		when(containerSeco.metrosCubicos()).thenReturn(60);
		
		Container containerReefer = mock(ContainerReefer.class);
		when(containerReefer.getKWPorHoras()).thenReturn(80);
		when(containerReefer.metrosCubicos()).thenReturn(100);
			
		Container containerTanque = mock(ContainerTanque.class);
		when(containerTanque.metrosCubicos()).thenReturn(60);
		
		servicioContainerElectricidad = new ServicioElectricidad(containerReefer, fechaHoraInicial, fechaHoraFinal);
		servicioContainerPesado = new ServicioPesado(containerTanque);
		servicioContainerLavadoSeco = new ServicioLavado(containerSeco);
		servicioContainerLavadoReefer = new ServicioLavado(containerReefer);
		servicioContainerAlmacenamiento = new ServicioAlmacenamiento(containerSeco, fechaHoraInicial, fechaHoraFinal, 50);		
	}
	
	@Test
	public void testContainer() {
		assertEquals(60, servicioContainerAlmacenamiento.getContainer().metrosCubicos());
		assertEquals(80, servicioContainerElectricidad.getContainer().getKWPorHoras());
	}
	
	@Test
	public void testServiciosCostos() {
		assertEquals(500, servicioContainerPesado.costoDelServicio(), 0.01);
		assertEquals(10, servicioContainerLavadoReefer.costoDelServicio(), 0.01);
		assertEquals(5, servicioContainerLavadoSeco.costoDelServicio(), 0.01);
		assertEquals(1280, servicioContainerElectricidad.costoDelServicio(), 0.01);
		assertEquals(0, servicioContainerAlmacenamiento.costoDelServicio(), 0.01);
	}
	
	@Test
	public void testCalculoDeHorasYDiasServicios() {
		LocalDateTime fechaHoraInicial = LocalDateTime.of(2010, 11, 15, 16, 0);
		LocalDateTime fechaHoraFinal = LocalDateTime.of(2010, 12, 15, 16, 0);
		assertEquals(0, servicioContainerElectricidad.cantidadDeDiasExcedentes(fechaHoraFinal, fechaHoraInicial));
		assertEquals(16, servicioContainerElectricidad.cantidadDeHorasExcedentes(fechaHoraFinal, fechaHoraInicial));
	}

}