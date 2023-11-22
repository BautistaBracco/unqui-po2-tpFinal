package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioAlmacenamiento;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioContainer;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioElectricidad;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioLavado;
import ar.edu.unq.po2.tpFinal.servicioContainer.ServicioPesado;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class TerminalTest {

	private Terminal terminal;
	
	@Before
	public void setUp() {
		ServicioContainer servicioElectricidad = mock(ServicioElectricidad.class);
		when(servicioElectricidad.costoDelServicio()).thenReturn(300.00);

		ServicioContainer servicioAlmacenamiento = mock(ServicioAlmacenamiento.class);
		when(servicioAlmacenamiento.costoDelServicio()).thenReturn(150.00);
		
		ServicioContainer servicioLavado = mock(ServicioLavado.class);
		when(servicioLavado.costoDelServicio()).thenReturn(400.00);

		ServicioContainer servicioPesado = mock(ServicioPesado.class);
		when(servicioPesado.costoDelServicio()).thenReturn(1000.00);
		
		List<ServicioContainer> serviciosOrdenDeImportacion = new ArrayList<>();
		serviciosOrdenDeImportacion.add(servicioAlmacenamiento);
		serviciosOrdenDeImportacion.add(servicioElectricidad);
		List<ServicioContainer> serviciosOrdenDeExportacion = new ArrayList<>();
		serviciosOrdenDeExportacion.add(servicioPesado);
		serviciosOrdenDeExportacion.add(servicioElectricidad);
		serviciosOrdenDeExportacion.add(servicioLavado);
		
		OrdenDeExportacion ordenDeExportacion = mock(OrdenDeExportacion.class);
		when(ordenDeExportacion.getServiciosDeContainer()).thenReturn(serviciosOrdenDeExportacion);
		OrdenDeImportacion ordenDeImportacion = mock(OrdenDeImportacion.class);
		when(ordenDeImportacion.getServiciosDeContainer()).thenReturn(serviciosOrdenDeImportacion);
		
		terminal = new Terminal("terminalUno");
		terminal.registrarOrdenDeExportacion(ordenDeExportacion);
		terminal.registrarOrdenDeImportacion(ordenDeImportacion);
	}
	
	@Test
	public void testTerminal() {
//		assertEquals(300.00, terminal.costoDeServiciosDeOrdenExportacion(ordenDeExportacion), 0.01);
//		assertEquals(300.00, terminal.costoDeServiciosDeOrdenImportacion(ordenDeImportacion), 0.01);
	}

}
