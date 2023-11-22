package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioAlmacenamiento;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioElectricidad;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioLavado;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioPesado;

public class OrdenTest {

	private OrdenDeImportacion ordenDeImportacion;
	private OrdenDeExportacion ordenDeExportacion;
	private LocalDateTime fechaDeLlegada;
	private LocalDateTime fechaDeSalida;
	
	@Before
	public void setUp() {
		
		Container container = mock(ContainerReefer.class);
		
		Viaje viaje = mock(Viaje.class);
		
		Camion camion = mock(Camion.class);
		
		Chofer chofer = mock(Chofer.class);
		
		Cliente shipper = mock(Cliente.class);
		
		ServicioContainer servicioElectricidad = mock(ServicioElectricidad.class);

		ServicioContainer servicioAlmacenamiento = mock(ServicioAlmacenamiento.class);

		ServicioContainer servicioLavado = mock(ServicioLavado.class);

		ServicioContainer servicioPesado = mock(ServicioPesado.class); 
		
		fechaDeSalida = LocalDateTime.of(2010, 01, 30, 8, 0);
		fechaDeLlegada = LocalDateTime.of(2010, 05, 10, 16, 0);
		
		ordenDeExportacion = new OrdenDeExportacion(container, shipper, camion, chofer, viaje, fechaDeSalida, fechaDeLlegada);
		
	}
	
	@Test
	public void testOrdenDeExportacionFechas() {
		assertEquals(2010, ordenDeExportacion.getFechaDeSalida().getYear());
		assertEquals(01, ordenDeExportacion.getFechaDeSalida().getMonthValue());
		assertEquals(30, ordenDeExportacion.getFechaDeSalida().getDayOfMonth());
		assertEquals(8, ordenDeExportacion.getFechaDeSalida().getHour());
	}
	
}
