package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class Arrived implements EstadoBuque {

	public void notificarTerminalDestino(Terminal terminal, Viaje viaje, Buque buque) {
		terminal.registrarBuqueAEsperaDeWorking(viaje.getBuque());
	}
}
