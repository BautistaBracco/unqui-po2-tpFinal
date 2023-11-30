package ar.edu.unq.po2.tpFinal.buque;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class Buque {

	private Terminal terminalOrigen; // pensarlo
	private Terminal terminalDestino; // seria mejor un viaje, pero viaje no tiene terminal destino.
	private Viaje viaje;
	private List<Container> containers;
	private EstadoBuque estado;
	
	public Buque(Viaje viaje, Terminal terminalDestino) {
		this.viaje = viaje;
		this.terminalOrigen = viaje.getTerminalOrigen();
		this.terminalDestino = terminalDestino;
		this.containers = new ArrayList<>();
	}
	
	public void setEstado(EstadoBuque estado) {
        this.estado = estado;
    }
	
	public void setDistanciaATerminalDestino(int distanciaATerminalDestino) {
		if (distanciaATerminalDestino >= 0) {
			if (distanciaATerminalDestino > 50) {
				this.setEstado(new Outbound());
			} else if (distanciaATerminalDestino == 0) {
				this.setEstado(new Arrived());
			} else {
				this.setEstado(new Inbound());
			}
		}

	}
	
	public void setViaje(Viaje viaje) {
		// Esta pensado para que el setter lo use la terminal cuando pase el buque a departing
		this.viaje = viaje;
	}
	
	public void notificarTerminal() {
		this.estado.notificarTerminalOrigen(terminalOrigen, viaje, this);
		this.estado.notificarTerminalDestino(terminalDestino, viaje, this);
	}
	
	public List<Container> getContainers() {
		return this.containers;
	}
	
	public void agregarContenedor(Container container) {
		containers.add(container);
	}
	
}
