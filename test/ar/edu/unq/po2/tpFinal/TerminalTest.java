package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeExportacion;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class TerminalTest {

	private Terminal terminal;
	
	@Before
	public void setUp() {
		
		terminal = new Terminal("terminalUno");
		terminal.registrarOrdenDeExportacion(ordenDeExportacionMock(300.00));
		terminal.registrarOrdenDeImportacion(ordenDeImportacionMock(500.00));
		terminal.registrarChofer(choferMock("Juan"));
	}
	
	@Test
	public void testTerminal() {
		
		assertEquals(300.00, terminal.costoDeServiciosDeOrdenExportacion(ordenDeExportacionMock(300.00)), 0.01);
		assertEquals(600.00, terminal.costoDeServiciosDeOrdenImportacion(ordenDeImportacionMock(500.00)), 0.01);
		assertEquals(true, terminal.estaElChoferRegistrado(choferMock("Juan")));
	}

	private OrdenDeExportacion ordenDeExportacionMock(double costo) {
		OrdenDeExportacion ordenDeExportacion = mock(OrdenDeExportacion.class);
		when(ordenDeExportacion.costoDeServicios()).thenReturn(costo);
		return ordenDeExportacion;
	}
	
	private OrdenDeImportacion ordenDeImportacionMock(double costo) {
		OrdenDeImportacion ordenDeImportacion = mock(OrdenDeImportacion.class);
		Viaje viaje = mock(Viaje.class);
		when(viaje.costoDeViaje(terminal)).thenReturn(100.00);
		when(ordenDeImportacion.getViaje()).thenReturn(viaje);
		when(ordenDeImportacion.getViaje().costoDeViaje(terminal)).thenReturn(100.00);
		when(ordenDeImportacion.costoDeServicios()).thenReturn(costo);
		return ordenDeImportacion;
	}
	
	private Chofer choferMock(String nombre) {
		Chofer chofer = mock(Chofer.class);
		when(chofer.getNombre()).thenReturn(nombre);
		return chofer;
	}
	
}
