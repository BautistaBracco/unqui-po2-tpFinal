package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioAlmacenamiento;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioElectricidad;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioLavado;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioPesado;

public class OrdenTest {

	private OrdenDeExportacion ordenDeExportacion;
	private LocalDateTime fechaDeLlegada;
	private LocalDateTime fechaDeSalida;
	private Container containerReefer;
	private Chofer chofer;
	private Camion camion;
	private Cliente shipper;
	private Viaje viaje;
	
	@Before
	public void setUp() { 
	
		ServicioContainer servicioElectricidad = mock(ServicioElectricidad.class);
		when(servicioElectricidad.costoDelServicio()).thenReturn(300.00);
		ServicioContainer servicioAlmacenamiento = mock(ServicioAlmacenamiento.class);
		when(servicioAlmacenamiento.costoDelServicio()).thenReturn(200.00);
		ServicioContainer servicioLavado = mock(ServicioLavado.class);
		when(servicioLavado.costoDelServicio()).thenReturn(100.00);
		ServicioContainer servicioPesado = mock(ServicioPesado.class);
		when(servicioPesado.costoDelServicio()).thenReturn(50.00);
		
		chofer = mock(Chofer.class);
		viaje = mock(Viaje.class);
		camion = mock(Camion.class);
		shipper = mock(Cliente.class);
		containerReefer = mock(ContainerReefer.class);
		
		fechaDeSalida = LocalDateTime.of(2010, 01, 30, 8, 0);
		fechaDeLlegada = LocalDateTime.of(2010, 05, 10, 16, 0);
		
		ordenDeExportacion = new OrdenDeExportacion(containerReefer, shipper, camion, chofer, viaje, fechaDeSalida, fechaDeLlegada);
		
		ordenDeExportacion.agregarServicio(servicioPesado);
		ordenDeExportacion.agregarServicio(servicioLavado);
		ordenDeExportacion.agregarServicio(servicioAlmacenamiento);
		ordenDeExportacion.agregarServicio(servicioElectricidad);
		
	}
	
	@Test
	public void testOrdenGetters() {
		assertEquals(containerReefer, ordenDeExportacion.getContainer());
		assertEquals(viaje, ordenDeExportacion.getViaje());
		assertEquals(camion, ordenDeExportacion.getCamion());
		assertEquals(chofer, ordenDeExportacion.getChofer());
		assertEquals(shipper, ordenDeExportacion.getCliente());
		assertEquals(4, ordenDeExportacion.getServiciosDeContainer().size());
	}
	
	@Test
	public void testCostoDeServicios() {
		assertEquals(650, ordenDeExportacion.costoDeServicios(), 0.01);
	}
	
	@Test
	public void testOrdenDeExportacionGetters() {
		assertEquals(2010, ordenDeExportacion.getFechaDeSalida().getYear());
		assertEquals(01, ordenDeExportacion.getFechaDeSalida().getMonthValue());
		assertEquals(30, ordenDeExportacion.getFechaDeSalida().getDayOfMonth());
		assertEquals(8, ordenDeExportacion.getFechaDeSalida().getHour());
		
		assertEquals(2010, ordenDeExportacion.getFechaDeLlegada().getYear());
		assertEquals(05, ordenDeExportacion.getFechaDeLlegada().getMonthValue());
		assertEquals(10, ordenDeExportacion.getFechaDeLlegada().getDayOfMonth());
		assertEquals(16, ordenDeExportacion.getFechaDeLlegada().getHour());
	}
	
}
