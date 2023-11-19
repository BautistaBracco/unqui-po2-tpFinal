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
import ar.edu.unq.po2.tpFinal.empresaTransportista.ChoferInterface;
import ar.edu.unq.po2.tpFinal.orden.Buque;
import ar.edu.unq.po2.tpFinal.orden.Cliente;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioAlmacenamiento;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioElectricidad;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioLavado;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioPesado;

public class OrdenTest {

	private Orden ordenDeExportacion;
	private Orden ordenDeImportacion;
	private LocalDateTime fechaDeLlegada;
	private LocalDateTime fechaDeSalida;
	
	@Before
	public void setUp() {
		
		Container container = mock(ContainerReefer.class);
		
		Buque buque = mock(Buque.class);
		
		Camion camion = mock(Camion.class);
		
		Chofer chofer = mock(Chofer.class);
		
		Cliente shipper = mock(Cliente.class);
		Cliente consignee = mock(Cliente.class);
		
		ServicioContainer servicioElectricidad = mock(ServicioElectricidad.class);
		when(servicioElectricidad.costoDelServicio()).thenReturn(100.00);
		ServicioContainer servicioAlmacenamiento = mock(ServicioAlmacenamiento.class);
		when(servicioAlmacenamiento.costoDelServicio()).thenReturn(50.00);
		ServicioContainer servicioLavado = mock(ServicioLavado.class);
		when(servicioLavado.costoDelServicio()).thenReturn(25.00);
		ServicioContainer servicioPesado = mock(ServicioPesado.class);
		when(servicioPesado.costoDelServicio()).thenReturn(5.00);
		
		fechaDeSalida = LocalDateTime.of(2010, 01, 30, 8, 0);
		fechaDeLlegada = LocalDateTime.of(2010, 05, 10, 16, 0);
		
		ordenDeExportacion = new OrdenDeExportacion(container, shipper, consignee, camion, chofer, buque, fechaDeLlegada, fechaDeSalida);
		ordenDeExportacion.agregarServicio(servicioLavado);
		ordenDeExportacion.agregarServicio(servicioPesado);
		ordenDeExportacion.agregarServicio(servicioElectricidad);
		ordenDeExportacion.agregarServicio(servicioAlmacenamiento);
		
		ordenDeImportacion = new OrdenDeExportacion(container, shipper, consignee, camion, chofer, buque, fechaDeLlegada, fechaDeSalida);
		ordenDeImportacion.agregarServicio(servicioAlmacenamiento);
		ordenDeImportacion.agregarServicio(servicioElectricidad);
		ordenDeImportacion.agregarServicio(servicioPesado);
		ordenDeImportacion.agregarServicio(servicioLavado);
		
	}
	
	@Test
	public void testOrdenDeExportacionFechas() {
		assertEquals(2010, ordenDeExportacion.getFechaDeSalida().getYear());
		assertEquals(01, ordenDeExportacion.getFechaDeSalida().getMonthValue());
		assertEquals(30, ordenDeExportacion.getFechaDeSalida().getDayOfMonth());
		assertEquals(8, ordenDeExportacion.getFechaDeSalida().getHour());
	}
	
	@Test
	public void testOrdenDeImportacionFechas() {
		assertEquals(2010, ordenDeImportacion.getFechaDeSalida().getYear());
		assertEquals(05, ordenDeImportacion.getFechaDeSalida().getMonthValue());
		assertEquals(10, ordenDeImportacion.getFechaDeSalida().getDayOfMonth());
		assertEquals(16, ordenDeImportacion.getFechaDeSalida().getHour());
	}
	
	@Test
	public void testOrdenDeImportacionCostoTotal() {
		assertEquals(130, ordenDeImportacion.costoTotalDeServiciosDeContainer(), 0.01);
	}
	
	@Test
	public void testOrdenDeExportacionCostoTotal() {
		assertEquals(150, ordenDeExportacion.costoTotalDeServiciosDeContainer(), 0.01);
	}

}
