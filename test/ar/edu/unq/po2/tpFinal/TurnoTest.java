package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.cliente.Turno;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;

public class TurnoTest {

	private Turno turno;
	private Cliente clienteMock;
	private Chofer choferMock;
	private Camion camionMock;
	private LocalDateTime fecha;
	
	@Before
	public void setUp() {
		clienteMock = mock(Cliente.class);
		choferMock = mock(Chofer.class);
		camionMock = mock(Camion.class);
		fecha = LocalDateTime.now();
		turno = new Turno(fecha, clienteMock, choferMock, camionMock);
		
	}
	
	@Test
	public void testTurno() {
		assertEquals(clienteMock, turno.getCliente());
		assertEquals(choferMock, turno.getChofer());
		assertEquals(camionMock, turno.getCamion());
		assertEquals(fecha, turno.getFechaHoraAsignada());
	}

}
