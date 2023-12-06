package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public interface EstadoBuque {
	default void notificarTerminalOrigen(Terminal terminal, Viaje viaje, Buque buque, Viaje viajeAnterior) {
		
	}
	default void notificarTerminalDestino(Terminal terminal, Viaje viaje, Buque buque) {
		
	}
	
}
