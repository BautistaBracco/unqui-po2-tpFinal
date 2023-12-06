package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.orden.OrdenDeImportacion;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class ClienteTest {

	private Cliente cliente;
	private Terminal terminalGestionada;
	
	@Before
	public void setUp() {
		cliente = new Cliente("Juan");
		
		terminalGestionada = mock(Terminal.class);
		Terminal terminalDestino = mock(Terminal.class);
		Viaje viaje = mock(Viaje.class);
		LocalDateTime fechaSalida = LocalDateTime.now();
        LocalDateTime fechaLlegada = fechaSalida.plusHours(2);
        LocalDateTime fechaAsignada = LocalDateTime.of(2010, 10, 10, 10, 10);
        when(viaje.getFechaDeSalida()).thenReturn(fechaSalida);
        when(viaje.getFechaDeLlegada(terminalDestino)).thenReturn(fechaLlegada);
		Container container = mock(Container.class);
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		when(terminalGestionada.estaElCamionRegistrado(camion)).thenReturn(true);
		when(terminalGestionada.estaElChoferRegistrado(chofer)).thenReturn(true);
		
		cliente.realizarPedidoDeImportacion(terminalGestionada, terminalDestino, viaje, container, camion, chofer);
		
		cliente.realizarPedidoDeExportacion(terminalGestionada, camion, chofer, fechaAsignada);
		
		cliente.llevarCargaALaTerminal(terminalGestionada, terminalDestino, fechaAsignada, viaje, container, camion, chofer);
	}
	
	@Test
	public void testClienteRegistroDeOrdenes() {
		verify(terminalGestionada).registrarOrdenDeImportacion(
                ArgumentMatchers.any(OrdenDeImportacion.class)
        );
	}
	
	@Test
	public void testClienteGetters() {
		Camion camion = mock(Camion.class);
		Chofer chofer = mock(Chofer.class);
		cliente.setCamion(camion);
		cliente.setChofer(chofer);
		assertEquals("Juan", cliente.getNombre());
		assertEquals(chofer, cliente.getChofer());
		assertEquals(camion, cliente.getCamion());
	}
	
}
