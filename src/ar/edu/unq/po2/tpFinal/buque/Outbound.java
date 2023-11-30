package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class Outbound implements EstadoBuque {
	
	public void notificarTerminalOrigen(Terminal terminal, Viaje viaje, Buque buque) {
		terminal.informarShippersDelViaje(viaje);
	}
}
