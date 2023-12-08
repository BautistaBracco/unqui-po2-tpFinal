package ar.edu.unq.po2.tpFinal.buque;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.terminal.Terminal;
import ar.edu.unq.po2.tpFinal.viaje.Viaje;

public class Buque {
	private Terminal terminalDestino;
	private Viaje viajeAnterior;
	private Viaje viajeActual;
	private List<Container> containers;
	private EstadoBuque estado;
	
	public Buque(Viaje viaje, Terminal terminalDestino) {
		this.viajeAnterior = null;
		this.viajeActual = viaje;
		this.terminalDestino = terminalDestino;
		this.containers = new ArrayList<>();
	}
	
	public void setEstado(EstadoBuque estado) {
        this.estado = estado;
    }
	
	public void setViajeAnterior(Viaje viaje) {
		this.viajeAnterior = viaje;
	}
	
	public void setViaje(Viaje viaje) {
		this.viajeActual = viaje;
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
	
	public void notificarTerminal() {
		this.estado.notificarTerminalOrigen(this.viajeActual.getTerminalOrigen(), viajeActual, this, viajeAnterior);
		this.estado.notificarTerminalDestino(terminalDestino, viajeActual, this);
	}
	
	public List<Container> getContainers() {
		return this.containers;
	}
	
	public void agregarContenedor(Container container) {
		containers.add(container);
	}
	
}
