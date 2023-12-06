package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpFinal.buque.Arrived;
import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.Departing;
import ar.edu.unq.po2.tpFinal.buque.EstadoBuque;
import ar.edu.unq.po2.tpFinal.buque.Inbound;
import ar.edu.unq.po2.tpFinal.buque.Outbound;
import ar.edu.unq.po2.tpFinal.buque.Working;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class BuqueTest {

	private Buque buque;
	private Buque buqueMock;
	private Viaje viajeMock;
	private EstadoBuque estadoOutboundMock;
	private EstadoBuque estadoDepartingMock;
	private Terminal terminalMock;
	
	private EstadoBuque estadoDeparting;
	private EstadoBuque estadoDepartingSpy;
	
	private EstadoBuque estadoArrived;
	private EstadoBuque estadoArrivedSpy;
	
	private EstadoBuque estadoWorking;
	private EstadoBuque estadoWorkingSpy;
	
	private EstadoBuque estadoInbound;
	private EstadoBuque estadoInboundSpy;
	
	private EstadoBuque estadoOutbound;
	private EstadoBuque estadoOutboundSpy;
	
	@Before
	public void setUp() {
		Container container = mock(ContainerReefer.class);
		estadoOutboundMock = mock(Outbound.class);
		estadoDepartingMock = mock(Departing.class);
		viajeMock = mock(Viaje.class);
		when(viajeMock.getTerminalOrigen()).thenReturn(terminalMock);
		terminalMock = mock(Terminal.class);
		buque = new Buque(viajeMock, terminalMock);

		buqueMock = spy(buque);
		
		buque.agregarContenedor(container);
		buqueMock.setViaje(viajeMock);
		buqueMock.setEstado(estadoOutboundMock);
		buqueMock.setDistanciaATerminalDestino(2);
		buqueMock.setDistanciaATerminalDestino(100);
		buqueMock.setDistanciaATerminalDestino(0);
		
		buqueMock.setEstado(estadoDepartingMock);
		buqueMock.notificarTerminal();

		estadoDeparting = new Departing();
		estadoDepartingSpy = spy(estadoDeparting);
		
		estadoDepartingSpy.notificarTerminalDestino(terminalMock, viajeMock, buque);
		estadoDepartingSpy.notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
		
		estadoArrived = new Arrived();
		estadoArrivedSpy = spy(estadoArrived);
		
		estadoArrivedSpy.notificarTerminalDestino(terminalMock, viajeMock, buque);
		estadoArrivedSpy.notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
		
		estadoWorking = new Working();
		estadoWorkingSpy = spy(estadoWorking);
		
		estadoWorkingSpy.notificarTerminalDestino(terminalMock, viajeMock, buque);
		estadoWorkingSpy.notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
		
		estadoOutbound = new Outbound();
		estadoOutboundSpy = spy(estadoOutbound);
		
		estadoOutboundSpy.notificarTerminalDestino(terminalMock, viajeMock, buque);
		estadoOutboundSpy.notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
		
		estadoInbound = new Inbound();
		estadoInboundSpy = spy(estadoInbound);
		
		estadoInboundSpy.notificarTerminalDestino(terminalMock, viajeMock, buque);
		estadoInboundSpy.notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
		
	}
	
	@Test
	public void testContainers() {
		assertEquals(1, buque.getContainers().size());
	}
	
	@Test
	public void testSetters() {
		verify(buqueMock, times(1)).setViaje(viajeMock);
		verify(buqueMock, times(1)).setEstado(estadoOutboundMock);
		verify(buqueMock, times(1)).setDistanciaATerminalDestino(2);
		verify(buqueMock, times(1)).setDistanciaATerminalDestino(100);
		verify(buqueMock, times(1)).setDistanciaATerminalDestino(0);
	}

	@Test
	public void testNotificar() {
        verify(buqueMock, times(1)).notificarTerminal();
        
        verify(estadoOutboundSpy, times(1)).notificarTerminalDestino(terminalMock, viajeMock, buque);
        verify(estadoOutboundSpy, times(1)).notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
        
        verify(estadoInboundSpy, times(1)).notificarTerminalDestino(terminalMock, viajeMock, buque);
        verify(estadoInboundSpy, times(1)).notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
        
        verify(estadoDepartingSpy, times(1)).notificarTerminalDestino(terminalMock, viajeMock, buque);
        verify(estadoDepartingSpy, times(1)).notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
        
        verify(estadoWorkingSpy, times(1)).notificarTerminalDestino(terminalMock, viajeMock, buque);
        verify(estadoWorkingSpy, times(1)).notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
        
        verify(estadoArrivedSpy, times(1)).notificarTerminalDestino(terminalMock, viajeMock, buque);
        verify(estadoArrivedSpy, times(1)).notificarTerminalOrigen(terminalMock, viajeMock, buque, viajeMock);
	}
	
}
